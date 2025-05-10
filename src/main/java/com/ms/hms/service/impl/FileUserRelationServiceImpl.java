package com.ms.hms.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.hms.entity.SysFile;
import com.ms.hms.entity.SysFileUser;
import com.ms.hms.mapper.SysFileMapper;
import com.ms.hms.mapper.SysFileUserMapper;
import com.ms.hms.service.FileUserRelationService;
import com.ms.hms.service.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class FileUserRelationServiceImpl extends ServiceImpl<SysFileUserMapper, SysFileUser> implements FileUserRelationService {

  @Autowired
  private SysFileUserMapper sysFileUserMapper;
  @Override
  public int saveFile(Long userId, Long fileId) {
    SysFileUser sysFileUser = sysFileUserMapper.selectOne(Wrappers.<SysFileUser>lambdaQuery().eq(SysFileUser::getUserId, userId).eq(SysFileUser::getFileId, fileId));
    if (sysFileUser != null) {
     return sysFileUserMapper.update(null, Wrappers.<SysFileUser>lambdaUpdate()
          .set(SysFileUser::getUpdateTime, new Timestamp(System.currentTimeMillis()))
          .set(SysFileUser::getUserId, userId)
          .set(SysFileUser::getFileId, fileId)
          .eq(SysFileUser::getId, sysFileUser.getId())
      );
    } else {
      SysFileUser newFileUser = new SysFileUser();
      newFileUser.setFileId(fileId);
      newFileUser.setUserId(userId);
      newFileUser.setCreateTime(new Timestamp(System.currentTimeMillis()));
      return sysFileUserMapper.insert(newFileUser);
    }
  }
}
