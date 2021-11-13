package com.ms.hms.controller;

import com.ms.hms.common.Constants;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.Param.UserParam;
import com.ms.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
