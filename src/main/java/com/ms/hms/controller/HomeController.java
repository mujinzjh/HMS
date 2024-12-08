package com.ms.hms.controller;

import com.ms.hms.common.result.R;
import com.ms.hms.exception.ExceptionCode;
import com.ms.hms.exception.ServiceException;
import com.ms.hms.service.RoleService;
import com.ms.hms.service.SysLogService;
import com.ms.hms.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

  @Autowired
  private UserService userService;
  @Autowired
  private SysLogService sysLogService;
  @Autowired
  private RoleService roleService;


  @GetMapping(value = "/total")
  public R getTotalCount() throws UnsupportedEncodingException {
    Map<String, Object> resultMap = new HashMap<>();
    int userCount = userService.getUserTotal("");
    int roleCount = roleService.getRoleTotal("");
    int visitCount = sysLogService.getVisitUser();
    resultMap.put("user", userCount);
    resultMap.put("role", roleCount);
    resultMap.put("visit",visitCount);
    return R.ok().data(resultMap);
  }

  @GetMapping(value = "/visitNum")
  public R getVisitNumber(Integer type) throws UnsupportedEncodingException {
    List<Map<String, Object>> result = new ArrayList<>();
    LocalDate currentDate = LocalDate.now();
    LocalDate startDate, endDate;
    switch (type) {
      case 1:
        startDate = currentDate.with(DayOfWeek.MONDAY);
        endDate = startDate.plusWeeks(1).minusDays(1);
        break;
      case 2:
        startDate = currentDate.with(TemporalAdjusters.firstDayOfMonth());
        endDate = currentDate.with(TemporalAdjusters.lastDayOfMonth());
        break;
      case 3:
        startDate = currentDate.with(TemporalAdjusters.firstDayOfYear());
        endDate = currentDate.with(TemporalAdjusters.lastDayOfYear());
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + type);
    }
    Timestamp startTimestamp = Timestamp.valueOf(startDate.atTime(LocalTime.MIDNIGHT));
    Timestamp endTimestamp = Timestamp.valueOf(endDate.atTime(LocalTime.MAX));
    if (type == 3) {
        result = sysLogService.getUsersByYear(startTimestamp, endTimestamp);
    } else {
      result = sysLogService.getUsersByDate(startTimestamp, endTimestamp);
    }
    return R.ok().data(result);
  }
}
