package com.ms.hms.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ms.hms.exception.ExceptionCode;
import com.ms.hms.exception.ResultHttpCode;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"code", "message", "result"})
public class R implements Serializable, BaseR {
    private static final long serialVersionUid = 3592870491713692828L;

    //响应代码
    private String code;

    //响应信息
    @JsonProperty(value = "message")
    private String msg;


    //具体错误信息
    private String desc;

    //响应结果
    @JsonProperty(value = "result")
    private transient Object data;

    //扩展信息
    @JsonProperty(value = "ext")
    private transient Object ext;

    @Tolerate
    public R() {
    }

    public R(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(BaseR r) {
        this.code = r.getCode();
        this.msg = r.getMsg();
        this.desc = r.getDesc();
    }

    public R(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R(String code, String msg, String desc, Object data) {
        this.code = code;
        this.msg = msg;
        this.desc = desc;
        this.data = data;
    }


    public static R ok() {
        return new R(ResultHttpCode.SUCCESS.getCode(), ResultHttpCode.SUCCESS.getMsg(), null);
    }

    public static R fail(ResultHttpCode r) {
        return new R(r.getCode(), r.getMsg(), r.getDesc(), null);
    }

    public static R fail(String code, String msg, String desc) {
        return new R(code, msg, desc, null);
    }

    public static R fail(ExceptionCode e) {
        return new R(e.getCode(), e.getMsg(), e.getDesc(), null);
    }

    public R code(String code) {
        this.code = code;
        return this;
    }

    public R msg(String msg) {
        this.msg = msg;
        return this;
    }

    public R desc(String desc) {
        this.desc = desc;
        return this;
    }

    public R data(Object data) {
        this.data = data;
        return this;
    }

    public R ext(Object ext) {
        this.ext = ext;
        return this;
    }
}
