package com.ms.hms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.SysLog;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SysLogService extends IService<SysLog> {
    int saveLog(SysLog sysLog);

    R getSysLog(Integer pageNo, Integer pageSize, String search);

    int getVisitUser();

    List<Map<String, Object>> getUsersByDate(Timestamp startDate, Timestamp endDate);

    List<Map<String, Object>> getUsersByYear(Timestamp startDate, Timestamp endDate);

    SysLog getLatestLog(String result);

}
