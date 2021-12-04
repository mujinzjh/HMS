package com.ms.hms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName(value = "tb_sys_menu")
public class MenuDo implements Serializable {
    public static final Integer STATUS_ENABLE = 1;

    public static final Integer STATUS_DISABLE = 0;

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer type;

    private String permission;

    private String path;

    private String icon;

    @TableField(value = "parent_id")
    private Long pid;

    private Integer status;

    @TableField(exist = false)
    private List<MenuDo> children;


}
