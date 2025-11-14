package com.ms.hms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.hms.entity.SysFile;

public interface SysFileService extends IService<SysFile> {
  int saveFile(Long userId, String obsPath, String filePath, String fileName);
}
