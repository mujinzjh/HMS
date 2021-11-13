package com.ms.hms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.hms.entity.SysLog;

import java.util.List;
import java.util.Map;


public interface SysLogMapper extends BaseMapper<SysLog> {
    List<SysLog> getSysLogList(Map search);

    int getSysLogListCount(Map search);

}
