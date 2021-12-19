package com.ms.hms.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.hms.common.PageModel;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.MenuDo;
import com.ms.hms.entity.Param.UserParam;
import com.ms.hms.entity.SysRole;
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
import java.util.HashMap;
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
        if (userParam.getId() == null) {
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
        } else {
            try {
                userMapper.updateUser(userParam.getId(),userParam.getAvatar(),userParam.getDes(),userParam.getEmail(),String.valueOf(userParam.getUsername()),System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }

            SysUserRole sysUserRole = sysUserRoleMapper.selectOne(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId,userParam.getId()));
            if (null != sysUserRole){
                if (sysUserRole.getRoleId() != userParam.getRoleId()) {
                        sysUserRoleMapper.update(null,Wrappers.<SysUserRole>lambdaUpdate().set(SysUserRole::getRoleId,userParam.getRoleId()).eq(SysUserRole::getId,sysUserRole.getId()));
                }
            }
        }

        return R.ok();
    }

//    获取用户列表
    @Override
    public R getUserListInfo(Integer pageNo, Integer pageSize, String search) {
        Map searchMap = null;

        try {
            searchMap = JSON.parseObject(search);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == searchMap) {
            searchMap = new HashMap<>(1);
        }
        List<SysUser> list = new ArrayList<>();
        int count = userMapper.getUserCount(searchMap);
        PageModel pageModel = PageModel.newPageModel(pageSize, pageNo, count);
        if (count <= 0) {
            return R.ok().data(list).ext(pageModel);
        }

        searchMap.put("offset", pageModel.getOffset());
        searchMap.put("pageSize", pageSize);
        list = userMapper.getRoleList(searchMap);
        return R.ok().data(list).ext(pageModel);
    }

    @Override
    public Map<Long, MenuDo> queryMenuByUserId(Long userId) {
        List<MenuDo> menuList = menuMapper.queryMenuByUserId(userId);
        Map<Long, MenuDo> menuMap = menuList.stream().collect(Collectors.toMap(MenuDo::getId, menu -> menu));
        menuList.stream().filter(menu -> menu.getPid() != 0L).forEach(menu -> {
            setMenuChild(menuMap, menu);
        });
        return menuMap.values().stream().filter(menu -> menu.getPid() == 0L).collect(Collectors.toMap(MenuDo::getId, menu -> menu));
    }

    private void setMenuChild(Map<Long, MenuDo> menuMap, MenuDo menu) {
        MenuDo parentFunc = menuMap.get(menu.getPid());
        if (null != parentFunc) {
            List<MenuDo> menus = parentFunc.getChildren();
            if (null == menus) {
                menus = new ArrayList<>();
            }
            menus.add(menu);
            parentFunc.setChildren(menus);
            menuMap.put(parentFunc.getId(), parentFunc);
            if (parentFunc.getPid() != 0L) {
                setMenuChild(menuMap, parentFunc);
            }
        }
    }

}
