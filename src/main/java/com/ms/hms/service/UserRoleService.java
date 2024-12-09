package com.ms.hms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.hms.entity.SysUserRole;

import java.util.List;
import java.util.Map;

public interface UserRoleService extends IService<SysUserRole> {
  List<Map<String, Object>> getRoleSituationCount();
}
