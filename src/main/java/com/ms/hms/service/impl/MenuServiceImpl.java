package com.ms.hms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.hms.entity.MenuDo;
import com.ms.hms.mapper.MenuMapper;
import com.ms.hms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuDo> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public Map<Long, MenuDo> getAllPermissionMneus() {
        List<MenuDo> menuList = menuMapper.getExceptSystemMenus();
        Map<Long, MenuDo> menuMap = menuList.stream().collect(Collectors.toMap(MenuDo::getId, menu -> menu));
        menuList.stream().filter(menu -> menu.getPid() != 0L).forEach(menu -> {
                    setMenuChildren(menuMap, menu);
                }
        );
        return menuMap.values().stream().filter(menu -> menu.getPid() == 0L ).collect(Collectors.toMap(MenuDo::getId,menu -> menu));
    }

    private void setMenuChildren(Map<Long, MenuDo> menuMap, MenuDo menu) {
        MenuDo parentFunc = menuMap.get(menu.getPid());
        System.out.println(parentFunc);
        if (null!=parentFunc){
            List<MenuDo> menus = parentFunc.getChildren();
            if (menus==null){
                menus = new ArrayList<>();
            }
            menus.add(menu);
            parentFunc.setChildren(menus);
            menuMap.put(parentFunc.getId(),parentFunc);
            if (parentFunc.getPid()!=0L){
                setMenuChildren(menuMap,parentFunc);
            }
        }
    }
}
