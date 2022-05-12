package com.ms.hms.exception;

import com.ms.hms.common.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    public Object handlerException(ServiceException exception, HttpServletResponse resp) {
        log.error("业务错误",exception);
        if (exception.getErrorCode() == "401") {
            resp.setStatus(401);
        } else {
            resp.setStatus(450);
        }
        return R.fail(exception.getErrorCode(),exception.getMsg(),exception.getDesc());
    }

}
