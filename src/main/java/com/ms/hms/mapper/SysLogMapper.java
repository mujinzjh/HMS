package com.ms.hms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.hms.entity.SysLog;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface SysLogMapper extends BaseMapper<SysLog> {
    List<SysLog> getSysLogList(Map search);

    int getSysLogListCount(Map search);

=======

public interface SysLogMapper extends BaseMapper<SysLog> {
>>>>>>> 77046095efe2b1a6d9c77fdbca41f5a97595b9bc
}
