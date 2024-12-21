package com.ms.hms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.SysFile;

import java.util.List;
import java.util.Map;

public interface FileService extends IService<SysFile> {
  Map<String, Object> getFileList(int page, int size, String search);

  int deleteFile(Long id);

  SysFile getFileInfo(Long id);
}
