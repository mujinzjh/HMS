package com.ms.hms.Interceptor;

import com.alibaba.fastjson.JSON;
import com.ms.hms.common.redis.RedisService;
import com.ms.hms.entity.SysUser;
import com.ms.hms.exception.ResultHttpCode;
import com.ms.hms.exception.ServiceException;
import com.ms.hms.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    public static final ThreadLocal<SysUser> THREAD_LOCAL = new ThreadLocal<>();
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            throw new ServiceException(ResultHttpCode.TOKEN_INVAILD);
        }
        String userStr = redisService.get(token);
        if (StringUtils.isBlank(userStr)) {
            throw new ServiceException(ResultHttpCode.TOKEN_INVAILD);
        }
        SysUser user = JSON.parseObject(userStr, SysUser.class);
        THREAD_LOCAL.set(user);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        THREAD_LOCAL.remove();
    }
}
