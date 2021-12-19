package com.ms.hms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.Param.AddRole;
import com.ms.hms.entity.Param.RoleInfo;
import com.ms.hms.entity.SysRole;
import com.ms.hms.entity.SysRoleMenu;


public interface RoleService extends IService<SysRoleMenu> {
    R getRoleList(Integer pageNo, Integer pageSize, String search);

    R addRole(AddRole addRole);

    RoleInfo findRoleByRoleId(Long roleId);

    void delRole(Long id);
}
