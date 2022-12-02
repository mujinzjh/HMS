package com.ms.hms.controller;

import com.alibaba.fastjson.JSON;
import com.ms.hms.Interceptor.TokenInterceptor;
import com.ms.hms.aop.Log;
import com.ms.hms.common.Constants;
import com.ms.hms.common.redis.RedisService;
import com.ms.hms.common.result.R;
import com.ms.hms.common.utils.TokenUtils;
import com.ms.hms.entity.LoginParam;
import com.ms.hms.entity.MenuDo;
import com.ms.hms.entity.SysUser;
import com.ms.hms.entity.UpdatePwd;
import com.ms.hms.exception.ExceptionCode;
import com.ms.hms.exception.ResultHttpCode;
import com.ms.hms.exception.ServiceException;
import com.ms.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    private static String token;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    @Log(value = "登录")
    @PostMapping(value = "/login")
    public R login(@RequestBody LoginParam loginParam, HttpServletRequest request) {
        SysUser user = userService.findByName(loginParam.getAccount());
        if (user == null || !loginParam.getPassword().equalsIgnoreCase(user.getPassword())) {
            throw new ServiceException(ExceptionCode.ACCOUNT_OR_PASSWORD_ERROR);
        }
        token = TokenUtils.createToken(user);
        String userStr = JSON.toJSONString(user);
        redisService.set(token, userStr, Constants.USER_TOKEN_EXPIRE);
        Map<String, Object> resultMap = new HashMap<>();
        Map<Long, MenuDo> menus = userService.queryMenuByUserId(user.getId());
        resultMap.put("user", user);
        resultMap.put("token", token);
        resultMap.put("menu", menus);
        return R.ok().data(resultMap);
    }


    // 修改密码
    @Log(value = "修改密码")
    @PostMapping(value = "/updatePwd")
    public R updatePwd(@RequestBody UpdatePwd uPwd) {
        if (uPwd.getOldPwd() == null || uPwd.getPassword() == null) {
            throw new ServiceException(ResultHttpCode.BUSINESS_FAILURE);
        }
        SysUser user = TokenInterceptor.THREAD_LOCAL.get();
        System.out.println(user);

        if (null == user) {
            throw new ServiceException(ResultHttpCode.TOKEN_INVAILD);
        }
        if (!uPwd.getOldPwd().equalsIgnoreCase(user.getPassword())) {
            throw new ServiceException(ExceptionCode.ACCOUNT_OR_PASSWORD_ERROR);
        }

        userService.updatePwd(user.getId(), uPwd.getPassword());
        return R.ok();
    }

    //修改密码
    @Log(value = "退出登录")
    @PostMapping(value = "/logOut")
    public R loginOut() {
        SysUser user = TokenInterceptor.THREAD_LOCAL.get();
        if (user == null) {
            throw new ServiceException(ResultHttpCode.TOKEN_INVAILD);
        }
        redisService.deleteKey(token);
        return R.ok();
    }

    @PostMapping(value = "/add")
    public R insertUser() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("llj");
        sysUser.setPassword("111111");
        sysUser.setAdminType((long) 1);

        userService.insertUser(sysUser);
        return R.ok();
    }

}
