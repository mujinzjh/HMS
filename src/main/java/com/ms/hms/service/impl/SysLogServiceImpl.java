package com.ms.hms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.hms.entity.SysLog;
import com.ms.hms.mapper.SysLogMapper;
import com.ms.hms.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper,SysLog> implements SysLogService {
    @Autowired
    private  SysLogMapper sysLogMapper;


    @Override
    public int saveLog(SysLog sysLog) {
        return sysLogMapper.insert(sysLog);
    }
}
