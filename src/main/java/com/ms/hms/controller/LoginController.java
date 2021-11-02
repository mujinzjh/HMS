package com.ms.hms.controller;

import com.ms.hms.common.result.R;
import com.ms.hms.common.utils.TokenUtils;
import com.ms.hms.entity.LoginParam;
import com.ms.hms.entity.SysUser;
import com.ms.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public R login(@RequestBody LoginParam loginParam, HttpServletRequest request){
        SysUser user = userService.findByName(loginParam.getAccount());
        String token = TokenUtils.createToken(user);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("user",user);
        resultMap.put("token",token);
        System.out.println(resultMap);
        return R.ok().data(resultMap);
    }
}
