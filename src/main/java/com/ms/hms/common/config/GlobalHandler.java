package com.ms.hms.common.config;

import com.ms.hms.common.result.BaseR;
import com.ms.hms.common.result.R;
import com.ms.hms.exception.BaseException;
import com.ms.hms.exception.ResultHttpCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalHandler {
    @ExceptionHandler(value = Exception.class)
    public R handlerException(Exception e){
        if (e instanceof BaseException){
            BaseR baseR = ((BaseException) e).getR();
            return new R(baseR);
        } else {
            return new R(ResultHttpCode.BUSINESS_FAILURE);
        }
    }
}
