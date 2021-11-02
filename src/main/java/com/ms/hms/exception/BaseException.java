package com.ms.hms.exception;

import com.ms.hms.common.result.BaseR;

public class BaseException extends RuntimeException {
    private BaseR r;
    private Object obj;

    public BaseException(){
        this(ResultHttpCode.BUSINESS_FAILURE,null);
    };

    public BaseException(BaseR r){
        this.r = r;
        this.obj = null;
    }

    public BaseException(BaseR r,Object obj){
        this.r = r;
        this.obj = obj;
    }

    public BaseException(String message){
        this(ResultHttpCode.BUSINESS_FAILURE,message);
    }

    public String getErrorCode(){
        return r.getCode();
    }
    public String getDesc(){
        return r.getDesc();
    }
    public String getMsg(){
        return r.getMsg();
    }

    public BaseR getR(){
        return r;
    }
}
