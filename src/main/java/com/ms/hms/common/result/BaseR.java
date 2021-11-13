package com.ms.hms.common.result;

public interface BaseR {
    //获取错误吗
    String getCode();

    //获取错误信息
    String getMsg();

    //获取错误描述
    String getDesc();

    //返回结果
    default Object getResult() {
        return null;
    }

}
