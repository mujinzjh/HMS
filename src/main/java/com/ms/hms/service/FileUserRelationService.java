package com.ms.hms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.hms.entity.SysFileUser;


public interface FileUserRelationService extends IService<SysFileUser> {
  int saveFile(Long userId, Long fileId);
}
