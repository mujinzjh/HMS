package com.ms.hms.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.hms.common.PageModel;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.MenuDo;
import com.ms.hms.entity.SysFile;
import com.ms.hms.exception.ExceptionCode;
import com.ms.hms.exception.ServiceException;
import com.ms.hms.mapper.SysFileMapper;
import com.ms.hms.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class FileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements FileService {

  @Autowired
  private SysFileMapper sysFileMapper;
  @Override
  public Map<String, Object> getFileList(int page, int size, String search) {
    Map<String, Object> searchMap = null;
    try {
      searchMap = JSON.parseObject(search);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (null == searchMap) {
      searchMap = new HashMap<>(1);
    }
    PageModel pageModel = PageModel.newPageModel(page, size, 0);
    searchMap.put("offset", pageModel.getOffset());
    searchMap.put("pageSize", size);
    searchMap.putIfAbsent("isDelete", 0);
    List<SysFile> fileList = sysFileMapper.getFileList(searchMap);
    if (fileList == null) {
      throw new ServiceException(ExceptionCode.GET_FILE_LIST_FAIL);
    }
    Map<String, Object> result = new HashMap<>(1);
    pageModel.setTotalRecord(fileList.size());
    result.put("ext", pageModel);
    result.put("list", fileList);
    return result;
  }

  @Override
  public int deleteFile(Long id) {
    return sysFileMapper.deleteById(id);
  }

  @Override
  public SysFile getFileInfo(Long id) {
    return sysFileMapper.selectById(id);
  }
}
