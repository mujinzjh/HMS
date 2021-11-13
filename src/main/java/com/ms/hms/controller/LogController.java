package com.ms.hms.controller;

import com.ms.hms.aop.Log;
import com.ms.hms.common.result.R;
import com.ms.hms.exception.ExceptionCode;
import com.ms.hms.exception.ServiceException;
import com.ms.hms.service.SysLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping(value = "/log")
public class LogController {
    @Autowired
    private SysLogService sysLogService;

    @Log(value = "查询日志")
    @GetMapping(value = "/sysLog")
    public R getSysLogList(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam("search") String search) throws UnsupportedEncodingException {
        if (pageNo == null || pageSize == null || StringUtils.isBlank(search)) {
            throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
        }
//        String searchStr = URLDecoder.decode(search,"utf8");
//        System.out.println(searchStr);
        return sysLogService.getSysLog(pageNo, pageSize, search);
    }
}
