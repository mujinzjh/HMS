package com.ms.hms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.hms.entity.MenuDo;

import java.util.List;

public interface MenuMapper extends BaseMapper<MenuDo> {
    List<MenuDo> queryMenuByUserId(Long userId);

    List<MenuDo> getExceptSystemMenus();
}
