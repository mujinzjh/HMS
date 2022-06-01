package com.ms.hms.controller;

import com.ms.hms.aop.Log;
import com.ms.hms.common.Constants;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.Param.UserParam;
import com.ms.hms.exception.ExceptionCode;
import com.ms.hms.exception.ServiceException;
import com.ms.hms.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaojianhua
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findUser")
    public R findById(Long id) {
        return R.ok().data(userService.findById(id));
    }


    @PostMapping(value = "/add")
    public R createUser(@RequestBody UserParam userParam) {
        return userService.createUser(userParam, Constants.DEFAULT_PASSWORD);
    }

    @GetMapping(value = "/list")
    public R getListInfo(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, @RequestParam("search") String search){
        if (pageNo == null || pageSize == null || StringUtils.isBlank(search)) {
            throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
        }
        return userService.getUserListInfo(pageNo, pageSize, search);
    }

    @DeleteMapping(value = "/del")
    public R delUser(Long id){
        if (id == null ){
            throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
        }
        return userService.delUser(id);
    }

}
