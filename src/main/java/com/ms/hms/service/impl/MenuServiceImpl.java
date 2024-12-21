package com.ms.hms.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.hms.common.PageModel;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.MenuDo;
import com.ms.hms.exception.ExceptionCode;
import com.ms.hms.exception.ServiceException;
import com.ms.hms.mapper.MenuMapper;
import com.ms.hms.service.MenuService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuDo> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public Map<Long, MenuDo> getAllPermissionMenus() {
        List<MenuDo> menuList = menuMapper.getExceptSystemMenus();
        return dealCommon(menuList);
    }

    @Override
    public R getAllMenus(int pageNo, int pageSize, String search) {
        Map<String, Object> searchMap = null;
        try {
            searchMap = JSON.parseObject(search);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == searchMap) {
            searchMap = new HashMap<>(1);
        }
        PageModel pageModel = PageModel.newPageModel(pageNo, pageSize, 0);
        searchMap.put("offset", pageModel.getOffset());
        searchMap.put("pageSize", pageSize);
        searchMap.putIfAbsent("status", 0);
        List<MenuDo> menuList = menuMapper.getMenuList(searchMap);
        Map<Long, MenuDo> result = dealCommon(menuList);
        Collection<MenuDo> list = result.values();
        pageModel.setTotalRecord(list.size());
        return R.ok().ext(pageModel).data(list);
    }

    @Override
    public void saveMenu(MenuDo menuDo) {
        if (menuDo.getId()==null){
            menuDo.setCreateTime(new Timestamp(System.currentTimeMillis()));
            menuDo.setStatus(1);
            menuMapper.insert(menuDo);
        } else {
           menuMapper.update(null, Wrappers.<MenuDo>lambdaUpdate().set(MenuDo::getName,menuDo.getName())
                .set(MenuDo::getPid,menuDo.getPid())
                .set(MenuDo::getIcon,menuDo.getIcon())
                .set(MenuDo::getPath,menuDo.getPath())
                .set(MenuDo::getPermission,menuDo.getPermission())
                .set(MenuDo::getType,menuDo.getType())
                .set(MenuDo::getUpdateTime, new Timestamp(System.currentTimeMillis()))
                .eq(MenuDo::getId,menuDo.getId()));
        }
    }

    @Override
    public int deleteMenu(Long id) {
        List<MenuDo> list = menuMapper.selectList(Wrappers.<MenuDo>lambdaQuery().eq(MenuDo::getPid, id));
        List<Integer> ids = new ArrayList<>();
        if (list.size() != 0) {
            list.forEach(menu -> ids.add(menu.getId().intValue()));
            ids.add(Math.toIntExact(id));
            menuMapper.batchUpdateStatus(ids);
            return ids.size();
        } else {
            UpdateWrapper<MenuDo> wrapper=new UpdateWrapper<>();
            wrapper.set("status", 0).set("update_time", new Timestamp(System.currentTimeMillis())).eq("id", id);
            return menuMapper.update(null, wrapper);
        }
    }

    @Override
    public MenuDo getInfo(Long id) {
        MenuDo menuDo = menuMapper.selectOne(Wrappers.<MenuDo>lambdaQuery().eq(MenuDo::getId, id));
        if (menuDo == null) {
            throw new ServiceException(ExceptionCode.GET_MENU_INFO_FAIL);
        }
        return menuDo;
    }

    @Override
    public List<MenuDo> getBySearch() {
        List<MenuDo> list = menuMapper.selectList(Wrappers.<MenuDo>lambdaQuery().eq(MenuDo::getStatus,1).eq(MenuDo::getPid, 0L));
        return !list.isEmpty() ? list : null;
    }

    private Map<Long, MenuDo> dealCommon(List<MenuDo> menuList) {
        Map<Long, MenuDo> menuMap = menuList.stream().collect(Collectors.toMap(MenuDo::getId, menu -> menu));
        menuList.stream().filter(menu -> menu.getPid() != 0L).forEach(menu -> {
                setMenuChildren(menuMap, menu);
            }
        );
        return menuMap.values().stream().filter(menu -> menu.getPid() == 0L ).collect(Collectors.toMap(MenuDo::getId,menu -> menu));
    }

    private void setMenuChildren(Map<Long, MenuDo> menuMap, MenuDo menu) {
        MenuDo parentFunc = menuMap.get(menu.getPid());
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
