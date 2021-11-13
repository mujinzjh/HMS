package com.ms.hms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.MenuDo;
import com.ms.hms.entity.Param.UserParam;
import com.ms.hms.entity.SysUser;

import java.util.Map;

public interface UserService extends IService<SysUser> {
    SysUser findById(Long id);

    SysUser findByName(String username);

    void updatePwd(Long id, String password);

    void insertUser(SysUser sysUser);

    R createUser(UserParam userParam, String defaultPwd);

    Map<Long, MenuDo> queryMenuByUserId(Long userId);

}
