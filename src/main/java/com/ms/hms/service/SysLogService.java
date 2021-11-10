package com.ms.hms.service;

import com.baomidou.mybatisplus.extension.service.IService;
<<<<<<< HEAD

import com.ms.hms.common.result.R;

=======
>>>>>>> 77046095efe2b1a6d9c77fdbca41f5a97595b9bc
import com.ms.hms.entity.SysLog;

public interface SysLogService extends IService<SysLog> {
    int saveLog(SysLog sysLog);
<<<<<<< HEAD

    R getSysLog(Integer pageNo, Integer pageSize, String search);

=======
>>>>>>> 77046095efe2b1a6d9c77fdbca41f5a97595b9bc
}
