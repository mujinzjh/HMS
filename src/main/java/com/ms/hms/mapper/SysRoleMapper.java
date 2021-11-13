package com.ms.hms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.SysRole;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper extends BaseMapper<SysRole> {
    int getRoleCount(Map searchMap);

    List<SysRole> getRoleList(Map searchMap);
}
