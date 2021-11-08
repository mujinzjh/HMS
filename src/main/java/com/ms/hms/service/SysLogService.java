package com.ms.hms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.hms.entity.SysLog;

public interface SysLogService extends IService<SysLog> {
    int saveLog(SysLog sysLog);
}
