package com.ms.hms.controller;


import com.ms.hms.aop.Log;
import com.ms.hms.common.result.R;
import com.ms.hms.common.utils.MapToListUtils;
import com.ms.hms.entity.MenuDo;
import com.ms.hms.entity.Param.AddRole;
import com.ms.hms.exception.ExceptionCode;
import com.ms.hms.exception.ServiceException;
import com.ms.hms.service.MenuService;
import com.ms.hms.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Log(value = "查看角色列表")
    @GetMapping(value = "/roleList")
    public R getRoleList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, @RequestParam("search") String search) {
        if (pageNo == null || pageSize == null || StringUtils.isBlank(search)) {
            throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
        }
        return roleService.getRoleList(pageNo, pageSize, search);
    }

    @Log(value = "添加角色")
    @PostMapping(value = "/add")
    public R addRole(@RequestBody AddRole addRole) {
        try {
            if (StringUtils.isBlank(addRole.getName()) || StringUtils.isBlank(addRole.getMenuIds())) {
                throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return roleService.addRole(addRole.getName(), addRole.getMenuIds());
    }


    @Log(value = "删除角色")
    @DeleteMapping(value = "/del")
    public R delRole(Long id){
        if (null == id) {
            throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
        }
        roleService.delRole(id);
        return R.ok();
    }

    @GetMapping(value = "/info")
    public R findRoleByRoleId(Long roleId){

        return R.ok().data(roleService.findRoleByRoleId(roleId));
    }

    @Log(value = "获取菜单")
    @GetMapping(value = "/getAllPermissionMenus")
    public R getAllPermissionMenus() {
        Map<Long, MenuDo> menu = menuService.getAllPermissionMneus();
        List<MenuDo> menus = MapToListUtils.mapToList(menu);
        return R.ok().data(menus);
    }

}
