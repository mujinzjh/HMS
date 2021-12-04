package com.ms.hms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.hms.entity.MenuDo;

import java.util.Map;

public interface MenuService extends IService<MenuDo> {
    Map<Long,MenuDo> getAllPermissionMneus();
}
