package com.ms.hms.controller;


import com.ms.hms.aop.Log;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.Param.AddRole;
import com.ms.hms.exception.ExceptionCode;
import com.ms.hms.exception.ServiceException;
import com.ms.hms.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

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
}
