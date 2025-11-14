package com.ms.hms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.hms.entity.MenuDo;

import java.util.List;
import java.util.Map;

public interface MenuMapper extends BaseMapper<MenuDo> {
    List<MenuDo> queryMenuByUserId(Long userId);

    List<MenuDo> getExceptSystemMenus();

    List<MenuDo> getMenuList(Map searchMap);

    List<MenuDo> getBySearch();

    void batchUpdateStatus(List<Integer> ids);
}
