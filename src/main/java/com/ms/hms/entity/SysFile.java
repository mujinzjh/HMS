package com.ms.hms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@TableName(value = "tb_file")
public class SysFile implements Serializable {
  @TableId(type = IdType.AUTO)

  private Long id;

  @TableField(value = "user_id")
  private Long userId;

  @TableField(value = "file_path")
  private String filePath;

  @TableField(value = "obs_path")
  private String obsPath;

  @TableField(value = "file_name")
  private String fileName;

  @TableField(value = "is_delete")
  private int isDelete;

  @TableField(value = "create_time")
  private Timestamp createTime;


  @TableField(value = "update_time")
  private Timestamp updateTime;
}
