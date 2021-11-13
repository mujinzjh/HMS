package com.ms.hms.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "tb_sys_role")
public class SysRole {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    @TableField(value = "create_time")
    private Long createTime;
}
