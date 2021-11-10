package com.ms.hms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "tb_sys_log")
public class SysLog implements Serializable {
<<<<<<< HEAD
    @TableId(type = IdType.AUTO)
=======
    @TableId (type=IdType.AUTO)
>>>>>>> 77046095efe2b1a6d9c77fdbca41f5a97595b9bc
    private Long id;

    private String username;

    private String operation;

<<<<<<< HEAD
    private long status;

    private String result;

=======
>>>>>>> 77046095efe2b1a6d9c77fdbca41f5a97595b9bc
    @TableField(value = "operation_time")
    private Long operationTime;
}
