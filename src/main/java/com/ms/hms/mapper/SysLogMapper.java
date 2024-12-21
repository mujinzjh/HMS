package com.ms.hms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.hms.entity.SysLog;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public interface SysLogMapper extends BaseMapper<SysLog> {
    List<SysLog> getSysLogList(Map search);

    int getSysLogListCount(Map search);

    int getVisitorCount();

    List<Map<String, Object>> countUsersByDate(Timestamp startDate, Timestamp endDate);

    List<Map<String, Object>> countUsersByYear(Timestamp startDate, Timestamp endDate);

    SysLog getLatestLog(String result);
}
