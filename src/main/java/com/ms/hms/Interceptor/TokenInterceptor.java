package com.ms.hms.Interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.ms.hms.entity.SysUser;
import com.ms.hms.exception.ResultHttpCode;
import com.ms.hms.exception.ServiceException;
import com.ms.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    public static final ThreadLocal<SysUser> THREAD_LOCAL= new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token == null){
            throw new ServiceException(ResultHttpCode.TOKEN_INVAILD);
        }
        String uId = "";

        try {
            uId = JWT.decode(token).getAudience().get(0);
        } catch (Exception e) {
            throw new ServiceException(ResultHttpCode.TOKEN_INVAILD);
        }
        SysUser user = userService.findById(Long.valueOf(uId));
        if (user == null){
            throw new ServiceException(ResultHttpCode.TOKEN_INVAILD);
        }
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();

        try {
            jwtVerifier.verify(token);
        } catch (Exception e) {
            throw new ServiceException(ResultHttpCode.TOKEN_INVAILD);
        }

        THREAD_LOCAL.set(user);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        THREAD_LOCAL.remove();
    }
}
