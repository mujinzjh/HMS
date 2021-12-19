package com.ms.hms.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.hms.common.PageModel;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.Param.AddRole;
import com.ms.hms.entity.Param.RoleInfo;
import com.ms.hms.entity.SysRole;
import com.ms.hms.entity.SysRoleMenu;
import com.ms.hms.exception.ExceptionCode;
import com.ms.hms.exception.ServiceException;
import com.ms.hms.mapper.SysRoleMapper;
import com.ms.hms.mapper.SysRoleMenuMapper;
import com.ms.hms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements RoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public R getRoleList(Integer pageNo, Integer pageSize, String search) {
        Map searchMap = null;

        try {
            searchMap = JSON.parseObject(search);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == searchMap) {
            searchMap = new HashMap<>(1);
        }
        List<SysRole> list = new ArrayList<>();
        int count = sysRoleMapper.getRoleCount(searchMap);
        PageModel pageModel = PageModel.newPageModel(pageSize, pageNo, count);
        if (count <= 0) {
            return R.ok().data(list).ext(pageModel);
        }

        searchMap.put("offset", pageModel.getOffset());
        searchMap.put("pageSize", pageSize);
        list = sysRoleMapper.getRoleList(searchMap);
        return R.ok().data(list).ext(pageModel);
    }

    @Override
    public R addRole(AddRole addRole) {
        if (null == addRole.getId()) {
            SysRole sysRole = new SysRole();
            sysRole.setName(addRole.getName());
            sysRole.setCreateTime(System.currentTimeMillis());
            sysRoleMapper.insert(sysRole);
            addRoleMenuRelation(sysRole.getId(), addRole.getMenuIds().split(","));
        } else {
            Integer record = sysRoleMapper.update(null,Wrappers.<SysRole>lambdaUpdate().set(SysRole::getName,addRole.getName()).eq(SysRole::getId,addRole.getId()));

            if (record != 0 ) {
                sysRoleMenuMapper.delete(Wrappers.<SysRoleMenu>lambdaQuery().eq(SysRoleMenu::getRoleId, addRole.getId()));
                addRoleMenuRelation(addRole.getId(), addRole.getMenuIds().split(","));
            } else {
                throw new ServiceException(ExceptionCode.ROLE_NOT_EXIST);
            }

        }
        return R.ok();
    }

    @Override
    public RoleInfo findRoleByRoleId(Long roleId) {
        SysRole sysRole = sysRoleMapper.selectOne(Wrappers.<SysRole>lambdaQuery().eq(SysRole::getId, roleId));
        if (sysRole == null) {
            return null;
        }
        List<SysRoleMenu> roleMenuList = sysRoleMenuMapper.selectList(Wrappers.<SysRoleMenu>lambdaQuery().eq(SysRoleMenu::getRoleId, roleId));

        StringBuilder menuIds = new StringBuilder();
        if (roleMenuList != null && roleMenuList.size() > 0) {
            for (SysRoleMenu sysRoleMenu : roleMenuList) {
                menuIds.append(sysRoleMenu.getMenuId()).append(",");
            }
        }

        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setId(roleId);
        roleInfo.setName(sysRole.getName());
        roleInfo.setMenuIds(menuIds.toString());
        roleInfo.setUpdateTime(String.valueOf(System.currentTimeMillis()));
        return roleInfo;
    }

    @Override
    public void delRole(Long id) {
        SysRole sysRole = sysRoleMapper.selectById(id);
        if (null == sysRole) {
            throw new ServiceException(ExceptionCode.ROLE_NOT_EXIST);
        }
        sysRole.setStatus(SysRole.Status.DELETE.code);
        sysRoleMapper.updateRole(sysRole);
    }

    public void addRoleMenuRelation(Long roleId, String[] menuIds) {
        List<SysRoleMenu> roleMenuList = new ArrayList<>();
        for (String menuId : menuIds) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(roleId);
            sysRoleMenu.setMenuId(Long.parseLong(menuId));
            sysRoleMenu.setCreateTime(System.currentTimeMillis());
            roleMenuList.add(sysRoleMenu);
        }
        this.saveBatch(roleMenuList);
    }


}
