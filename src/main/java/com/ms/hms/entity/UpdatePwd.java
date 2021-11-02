package com.ms.hms.entity;

import lombok.Data;

@Data
public class UpdatePwd {
    private String oldPwd;
    private String password;
}
