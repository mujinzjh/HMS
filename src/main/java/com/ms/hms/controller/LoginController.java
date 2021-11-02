package com.ms.hms.controller;

import com.ms.hms.Interceptor.TokenInterceptor;
import com.ms.hms.common.result.R;
import com.ms.hms.common.utils.TokenUtils;
import com.ms.hms.entity.LoginParam;
import com.ms.hms.entity.SysUser;
import com.ms.hms.entity.UpdatePwd;
import com.ms.hms.exception.ExceptionCode;
import com.ms.hms.exception.ResultHttpCode;
import com.ms.hms.exception.ServiceException;
import com.ms.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public R login(@RequestBody LoginParam loginParam, HttpServletRequest request){
        SysUser user = userService.findByName(loginParam.getAccount());
        String token = TokenUtils.createToken(user);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("user",user);
        resultMap.put("token",token);
        System.out.println(resultMap);
        return R.ok().data(resultMap);
    }


//    修改密码

    @PostMapping(value = "/updatePwd")
    public R updatePwd (@RequestBody UpdatePwd uPwd) {
        if (uPwd.getOldPwd() == null || uPwd.getPassword() == null) {
            throw new ServiceException(ResultHttpCode.BUSINESS_FAILURE);
        }
        SysUser user = TokenInterceptor.THREAD_LOCAL.get();
        System.out.println(user);

        if (null == user) {
            throw new ServiceException(ResultHttpCode.TOKEN_INVAILD);
        }
        if (!uPwd.getOldPwd().equalsIgnoreCase(user.getPassword())) {
            throw new ServiceException(ExceptionCode.PASSWORD_ERROR);
        }

        userService.updatePwd(user.getId(),uPwd.getPassword());
        return R.ok();
    }

    @PostMapping(value = "/add")
    public R insertUser () {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("llj");
        sysUser.setPassword("111111");
        sysUser.setAdminType((long) 1);

        userService.insertUser(sysUser);
        return R.ok();
    }

}
