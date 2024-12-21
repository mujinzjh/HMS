package com.ms.hms.controller;

import com.ms.hms.aop.Log;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.MenuDo;
import com.ms.hms.exception.ExceptionCode;
import com.ms.hms.exception.ServiceException;
import com.ms.hms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {

  @Autowired
  private MenuService menuService;

  @Log(value = "菜单列表")
  @GetMapping(value = "/list")
  public R getMenuList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, @RequestParam("search") String search) {
    if (pageNo == null || pageSize == null) {
      throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
    }
    return menuService.getAllMenus(pageNo, pageSize, search);
  };

  @Log(value = "添加菜单")
  @PostMapping(value = "/add")
  public R addMenu(@RequestBody MenuDo menuDo) {
    menuService.saveMenu(menuDo);
    return R.ok();
  }

  @Log(value = "删除菜单")
  @DeleteMapping(value = "/delete")
  public R addMenu(Long id) {
    if (id == null) {
      throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
    }
    int delCount = menuService.deleteMenu(id);
    if (delCount > 0 ) {
      return R.ok();
    } else {
      throw new ServiceException(ExceptionCode.DELETE_MENU_FAIL);
    }
  }

  @Log(value = "修改菜单")
  @PostMapping(value = "/update")
  public R updateMenu(@RequestBody MenuDo menuDo) {
    if (menuDo == null) {
      throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
    }
    menuService.saveMenu(menuDo);
    return R.ok();
  };

  @Log(value = "菜单信息")
  @PostMapping(value = "/info")
  public R getMenuInfo(Long id) {
    if (id == null) {
      throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
    }
    menuService.getInfo(id);
    return R.ok();
  };

  @Log(value = "目录列表")
  @GetMapping(value = "/dirList")
  public R getDirList() {
    List<MenuDo> menus =  menuService.getBySearch();
    return R.ok().data(menus);
  }
}
