package com.ms.hms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.hms.entity.SysFile;

import java.util.List;
import java.util.Map;

public interface SysFileMapper extends BaseMapper<SysFile> {

  List<SysFile> getFileList(Map<String, Object> searchMap);
}
