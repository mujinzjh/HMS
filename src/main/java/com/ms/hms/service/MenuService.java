package com.ms.hms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.hms.entity.MenuDo;

import java.util.List;
import java.util.Map;

public interface MenuService extends IService<MenuDo> {
    Map<Long,MenuDo> getAllPermissionMenus();

    Map<Long,MenuDo> getAllMenus();

    void saveMenu(MenuDo menuDo);

    int deleteMenu(Long id);

    MenuDo getInfo(Long id);

    List<MenuDo> getBySearch();
}
