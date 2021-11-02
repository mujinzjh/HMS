package com.ms.hms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.hms.entity.SysUser;

public interface UserService extends IService<SysUser> {
    SysUser findById(Long id);

    SysUser findByName(String username);
}
