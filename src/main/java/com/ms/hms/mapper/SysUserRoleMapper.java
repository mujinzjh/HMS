package com.ms.hms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.hms.entity.SysUserRole;

import java.util.List;
import java.util.Map;

public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

  List<Map<String, Object>> getRoleUsedCount();
}
