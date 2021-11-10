package com.ms.hms.aop;
<<<<<<< HEAD
import com.alibaba.fastjson.JSONObject;
import com.ms.hms.Interceptor.TokenInterceptor;
import com.ms.hms.common.Constants;
import com.ms.hms.common.result.R;
=======

>>>>>>> 77046095efe2b1a6d9c77fdbca41f5a97595b9bc
import com.ms.hms.Interceptor.TokenInterceptor;
import com.ms.hms.entity.LoginParam;
import com.ms.hms.entity.SysLog;
import com.ms.hms.entity.SysUser;
import com.ms.hms.service.SysLogService;
import com.ms.hms.service.UserService;
<<<<<<< HEAD
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
=======
>>>>>>> 77046095efe2b1a6d9c77fdbca41f5a97595b9bc
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class AopAspect {
    @Autowired
    private SysLogService sysLogService;

    @Autowired
    private UserService userService;

    @Pointcut("@annotation(com.ms.hms.aop.Log)")
    public void logPointCut() {

    }

<<<<<<< HEAD
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        String result = null;
        try {
            Object obj = point.proceed();

            if (obj != null) {
                R objR = (R) obj;
                String statusCode = objR.getCode();
                if (statusCode.equalsIgnoreCase(Constants.SUCCESS_CODE)) {
                    result = "成功";
                } else {
                    result = "失败";
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            result = e.getMessage();
            throw e;
        } finally {
            saveSysLog(point, result);
        }
    }


    //    @AfterReturning("logPointCut()")
    public void saveSysLog(ProceedingJoinPoint joinPoint, String result) {

        @AfterReturning("logPointCut()")
        public void saveSysLog (JoinPoint joinPoint){
            System.out.println("切面。。。。。");
            //保存日志
            SysLog sysLog = new SysLog();

            //从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            //获取切入点所在的方法
            Method method = signature.getMethod();

            String methodName = signature.getName();
            //获取连接点参数
            Object[] args = joinPoint.getArgs() ;
            System.out.println(args[0]);
            System.out.println("----------------");
            //设置用户名
            SysUser user;
            if (methodName.equalsIgnoreCase("login")) {
                LoginParam loginParam = (LoginParam) args[0];
                user = userService.findByName(loginParam.getAccount());
                sysLog.setUsername(user.getUsername());
            } else {
                user = TokenInterceptor.THREAD_LOCAL.get();
            }
            sysLog.setUsername(user.getUsername());

            if (methodName.equalsIgnoreCase("login") || methodName.equalsIgnoreCase("logOut")) {
                sysLog.setStatus(Constants.LOGIN_LOG);
            } else {
                sysLog.setStatus(Constants.OPERATION_LOG);
            }
            //获取操作
            Log log = method.getAnnotation(Log.class);
            if (log != null) {
                String value = log.value();
                //设置操作成功文本
                sysLog.setResult(value + result);
                sysLog.setOperation(value);//保存获取的操作
            }

            //设置操作时间
            sysLog.setOperationTime(System.currentTimeMillis());
            //调用service保存SysLog实体类到数据库
            sysLogService.saveLog(sysLog);
        }
=======
    @AfterReturning("logPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        System.out.println("切面。。。。。");
        //保存日志
        SysLog sysLog = new SysLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        String methodName = signature.getName();
        System.out.println("----------------");
        System.out.println("----------------");
        //获取连接点参数
        Object[] args = joinPoint.getArgs() ;
        System.out.println(args[0]);
        System.out.println("----------------");
        //设置用户名
        SysUser user;
        if (methodName.equalsIgnoreCase("login")) {
            LoginParam loginParam = (LoginParam) args[0];
            user = userService.findByName(loginParam.getAccount());
            sysLog.setUsername(user.getUsername());
        } else {
            user = TokenInterceptor.THREAD_LOCAL.get();
        }
        sysLog.setUsername(user.getUsername());
        //获取操作
        Log log = method.getAnnotation(Log.class);
        if (log != null) {
            String value = log.value();
            sysLog.setOperation(value);//保存获取的操作
        }

        //设置操作时间
        sysLog.setOperationTime(System.currentTimeMillis());
        //调用service保存SysLog实体类到数据库
        sysLogService.saveLog(sysLog);
    }
>>>>>>> 77046095efe2b1a6d9c77fdbca41f5a97595b9bc
}
