package com.ms.hms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName(value = "tb_file_user_relation")
public class SysFileUser {
  @TableId(type = IdType.AUTO)
  private Long id;

  @TableField(value = "user_id")
  private Long userId;

  @TableField(value = "file_id")
  private Long fileId;

  @TableField(value = "create_time")
  private Timestamp createTime;

  @TableField(value = "update_time")
  private Timestamp updateTime;
}
