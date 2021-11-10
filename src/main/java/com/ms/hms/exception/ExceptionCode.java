package com.ms.hms.exception;

import com.ms.hms.common.result.BaseR;
import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 *
 * http返回Code码
 * */
@Getter
@AllArgsConstructor
public enum ExceptionCode implements BaseR {

    TOKEN_IS_INVALID("10004", "no token", ""),
    PARAMTER_ERROR("10006", "param error", ""),
    ACCOUNT_OR_PASSWORD_ERROR("10005", "pwd error", "密码错误");


    private final String code;
    private final String msg;
    private final String desc;


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg(){
        return msg;
    }
    @Override
    public String getDesc(){
        return desc;
    }
}
