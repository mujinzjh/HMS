package com.ms.hms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Data
@TableName("tb_sys_menu")
@Alias("menuDo")
public class MenuDo {
    public static final Integer STATUS_ENABLE = 1;

    public static final Integer STATUS_DISABLE = 0;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "parent_id")
    private Long pId;

    @TableField(value = "type")
    private Integer type;

    @TableField(value = "permission")
    private String permission;

    @TableField(value = "path")
    private String path;

    @TableField(value = "status")
    private Integer status;

    @TableField(exist = false)
    private List<MenuDo> children;


}
