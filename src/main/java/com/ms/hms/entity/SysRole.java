package com.ms.hms.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "tb_sys_role")
public class SysRole implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    @TableField(value = "create_time")
    private Long createTime;

    private Integer status;

    public enum Status {
        INIT(1),
        DELETE(9);

        public Integer code;

        Status(Integer code){
            this.code = code;
        }
    }
}
