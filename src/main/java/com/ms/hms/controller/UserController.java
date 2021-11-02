package com.ms.hms.controller;

import com.ms.hms.common.result.R;
import com.ms.hms.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findUser")
    public R findById(Long id){
        return R.ok().data(userService.findById(id));
    }
}
