package com.ms.hms.entity.Param;

import lombok.Data;

@Data
public class UserParam {

    private Long id;

    private String username;

    private String avatar;

    private String email;

    private String des;

    private Long roleId;
}
