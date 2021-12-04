package com.ms.hms.common.utils;

import com.ms.hms.entity.MenuDo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MapToListUtils {
    public static List<MenuDo> mapToList(Map<Long,MenuDo> menuMap){
        Collection<MenuDo> valueCollection = menuMap.values();
        System.out.println(valueCollection);
        List<MenuDo> menuList = new ArrayList<MenuDo>(valueCollection);
        System.out.println(menuList);
        return menuList;
    }
}
