package com.ms.hms.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.hms.common.PageModel;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.SysRole;
import com.ms.hms.entity.SysRoleMenu;
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
        return R.ok().data(list);
    }

    @Override
    public R addRole(String name, String menuIds) {
        SysRole sysRole = new SysRole();
        sysRole.setName(name);
        sysRole.setCreateTime(System.currentTimeMillis());
        System.out.println(sysRole);
        sysRoleMapper.insert(sysRole);
        addRoleMenuRelation(sysRole.getId(), menuIds.split(","));
        return R.ok();
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
