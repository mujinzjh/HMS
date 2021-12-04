package com.ms.hms.entity.Param;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleInfo implements Serializable {
    private Long id;
    private String name;
    private String menuIds;
    private String menuNames;
    private String updateTime;
}
