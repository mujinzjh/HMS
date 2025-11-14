package com.ms.hms.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.hms.entity.SysFile;
import com.ms.hms.entity.SysFileUser;
import com.ms.hms.entity.SysRole;
import com.ms.hms.mapper.SysFileMapper;
import com.ms.hms.mapper.SysFileUserMapper;
import com.ms.hms.service.FileUserRelationService;
import com.ms.hms.service.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements  SysFileService {

  @Autowired
  private SysFileMapper sysFileMapper;
  @Autowired
  private SysFileUserMapper sysFileUserMapper;
  @Autowired
  private FileUserRelationService fileUserRelationService;



  @Override
  public int saveFile(Long userId, String obsPath, String filePath, String fileName) {
    SysFile existFile = sysFileMapper.selectOne(Wrappers.<SysFile>lambdaQuery().eq(SysFile::getObsPath, obsPath));
    System.out.println(existFile);
    if (existFile != null) {
      fileUserRelationService.saveFile(userId, existFile.getId());
      return sysFileMapper.update(null, Wrappers.<SysFile>lambdaUpdate()
          .set(SysFile::getUpdateTime, new Timestamp(System.currentTimeMillis()))
              .set(SysFile::getFilePath, filePath)
              .set(SysFile::getFileName, fileName)
              .set(SysFile::getObsPath, obsPath)
          .eq(SysFile::getId, existFile.getId()));
    } else {
      SysFile sysFile = new SysFile();
      sysFile.setObsPath(obsPath);
      sysFile.setFilePath(filePath);
      sysFile.setFileName(fileName);
      sysFile.setCreateTime(new Timestamp(System.currentTimeMillis()));
      sysFileMapper.insert(sysFile);
      return fileUserRelationService.saveFile(userId,sysFile.getId());
    }
  }
}
