package com.ms.hms.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.hms.common.PageModel;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.SysLog;
import com.ms.hms.mapper.SysLogMapper;
import com.ms.hms.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int saveLog(SysLog sysLog) {
        try {
            return sysLogMapper.insert(sysLog);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
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

    @Override
    public int getVisitUser() {

        return sysLogMapper.getVisitorCount();
    }

    @Override
    public List<Map<String, Object>> getUsersByDate(Timestamp startDate, Timestamp endDate) {
        List<Map<String, Object>> results = sysLogMapper.countUsersByDate(startDate, endDate);
        LocalDate start = startDate.toLocalDateTime().toLocalDate();
        LocalDate end = endDate.toLocalDateTime().toLocalDate();
        List<Map<String, Object>> resultMap = new ArrayList<>();;
        for (LocalDate date = start; !date.isAfter(end);date = date.plusDays(1)) {
            resultMap.add(getMapForDate(date, results));
        }
        return resultMap;
    }
    private static Map<String, Object> getMapForDate(LocalDate date, List<Map<String, Object>> results) {
        Map<String, Object> map = new HashMap<>();
        boolean found = false;
        for (Map<String, Object> result : results) {
            Date resultDate = (Date) result.get("date");
            if (resultDate != null && resultDate.toLocalDate().equals(date)) {
                map.put("date", resultDate);
                map.put("user_count", result.get("user_count"));
                found = true;
                break;
            }

        }
        if (!found) {
            map.put("date", date);
            map.put("user_count", 0);

        }
        return map;
    }
    @Override
    public List<Map<String, Object>> getUsersByYear(Timestamp startDate, Timestamp endDate) {
        List<Map<String, Object>> results = sysLogMapper.countUsersByYear(startDate, endDate);
        LocalDate start = startDate.toLocalDateTime().toLocalDate();
        LocalDate end = endDate.toLocalDateTime().toLocalDate();
        List<Map<String, Object>> resultMap = new ArrayList<>();;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

        for (LocalDate date = start; !date.isAfter(end);date = date.plusMonths(1)) {
            String curDate = formatter.format(date);
            Map<String, Object> map = new HashMap<>();
            boolean found = false;
            for (Map<String, Object> result : results) {
                String resultDate = (String) result.get("date");
                if (resultDate != null && resultDate.equals(curDate)) {
                    map.put("date", resultDate);
                    map.put("user_count", result.get("user_count"));
                    found = true;
                    resultMap.add(map);
                    break;
                }

            }
            if (!found) {
                map.put("date", curDate);
                map.put("user_count", 0);
                resultMap.add(map);
            }
        }
        return resultMap;
    }

}
