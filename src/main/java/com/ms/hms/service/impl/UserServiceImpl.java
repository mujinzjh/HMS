package com.ms.hms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.MenuDo;
import com.ms.hms.entity.Param.UserParam;
import com.ms.hms.entity.SysUser;
import com.ms.hms.entity.SysUserRole;
import com.ms.hms.mapper.MenuMapper;
import com.ms.hms.mapper.SysUserRoleMapper;
import com.ms.hms.mapper.UserMapper;
import com.ms.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public SysUser findById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public SysUser findByName(String username) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUsername, username);
        List<SysUser> _list = userMapper.selectList(queryWrapper);
        return _list.size() > 0 ? _list.get(0) : null;
    }

    @Override
    public void insertUser(SysUser user) {
        userMapper.insert(user);
    }

    @Transactional
    @Override
    public void updatePwd(Long id, String password) {
        try {
            userMapper.changePwd(id, password, System.currentTimeMillis());
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Override
    public R createUser(UserParam userParam, String defaultPwd) {
        SysUser user = new SysUser();
        user.setPassword(defaultPwd);
        user.setUsername(userParam.getUsername());
        user.setAvatar(userParam.getAvatar());
        user.setDes(userParam.getDes());
        user.setEmail(userParam.getEmail());
        user.setCreateTime(System.currentTimeMillis());
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(user.getId());
        sysUserRole.setRoleId(userParam.getRoleId());
        sysUserRole.setCreateTime(System.currentTimeMillis());

        try {
            sysUserRoleMapper.insert(sysUserRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.ok();
    }

    @Override
    public Map<Long, MenuDo> queryMenuByUserId(Long userId) {
        List<MenuDo> menuList = menuMapper.queryMenuByUserId(userId);
        Map<Long, MenuDo> menuMap = menuList.stream().collect(Collectors.toMap(MenuDo::getId, menu -> menu));
        menuList.stream().filter(menu -> menu.getPId() != 0L).forEach(menu -> {
            setMenuChild(menuMap, menu);
        });
        return menuMap.values().stream().filter(menu -> menu.getPId() == 0L).collect(Collectors.toMap(MenuDo::getId, menu -> menu));
    }

    private void setMenuChild(Map<Long, MenuDo> menuMap, MenuDo menu) {
        MenuDo parentFunc = menuMap.get(menu.getPId());
        if (null != parentFunc) {
            List<MenuDo> menus = parentFunc.getChildren();
            if (null == menus) {
                menus = new ArrayList<>();
            }
            menus.add(menu);
            parentFunc.setChildren(menus);
            menuMap.put(parentFunc.getId(), parentFunc);
            if (parentFunc.getPId() != 0L) {
                setMenuChild(menuMap, parentFunc);
            }
        }
    }

}
