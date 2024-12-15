package com.ms.hms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.hms.entity.SysFile;
import com.ms.hms.mapper.SysFileMapper;
import com.ms.hms.service.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements  SysFileService {

  @Autowired
  private SysFileMapper sysFileMapper;
  @Override
  public int saveFile(Long userId, String obsPath, String filePath, String fileName) {
    SysFile sysFile = new SysFile();
    sysFile.setUserId(userId);
    sysFile.setObsPath(obsPath);
    sysFile.setFilePath(filePath);
    sysFile.setFileName(fileName);
    sysFile.setCreateTime(new Timestamp(System.currentTimeMillis()));
    return sysFileMapper.insert(sysFile);
  }
}
