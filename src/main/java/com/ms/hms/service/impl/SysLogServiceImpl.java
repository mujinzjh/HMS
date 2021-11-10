package com.ms.hms.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.hms.common.PageModel;
import com.ms.hms.common.result.R;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.ms.hms.entity.SysLog;
import com.ms.hms.mapper.SysLogMapper;
import com.ms.hms.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper,SysLog> implements SysLogService {
    @Autowired
    private  SysLogMapper sysLogMapper;

    @Override
    public int saveLog(SysLog sysLog) {
        return sysLogMapper.insert(sysLog);
    }

    @Override
    public R getSysLog(Integer pageNo, Integer pageSize, String search) {
        Map searchMap = null;
        try {
            searchMap = JSON.parseObject(search);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        if (null == searchMap) {
            searchMap = new HashMap<>(1);
        }
        List<SysLog> list = new ArrayList<>();
        int count = sysLogMapper.getSysLogListCount(searchMap);
        PageModel pageModel = PageModel.newPageModel(pageSize, pageNo, count);
        if (count <= 0) {
            return R.ok().data(list).ext(pageModel);
        }
        searchMap.put("offset", pageModel.getOffset());
        searchMap.put("pageSize", pageSize);
        list = sysLogMapper.getSysLogList(searchMap);
        return R.ok().data(list).ext(pageModel);
    }
}
