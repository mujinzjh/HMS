package com.ms.hms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.hms.entity.SysUserRole;
import com.ms.hms.mapper.SysUserRoleMapper;
import com.ms.hms.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements UserRoleService {
  @Autowired
  private SysUserRoleMapper sysUserRoleMapper;

  @Override
  public List<Map<String, Object>> getRoleSituationCount() {
    return sysUserRoleMapper.getRoleUsedCount();
  }
}
