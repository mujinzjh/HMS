package com.ms.hms.controller;


import com.aliyun.oss.model.VoidResult;
import com.ms.hms.aop.Log;
import com.ms.hms.common.result.R;
import com.ms.hms.entity.SysFile;
import com.ms.hms.exception.ExceptionCode;
import com.ms.hms.exception.ServiceException;
import com.ms.hms.service.FileService;
import com.ms.hms.service.OSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/file")
public class FileController {
  @Autowired
  private FileService fileService;
  @Autowired
  private OSSService ossService;

  @Value("${aliyun.bucketName}")
  private String bucketName;

  @Log(value = "文件列表")
  @GetMapping(value = "/list")
  public R getFileList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, @RequestParam("search") String search) throws IOException {
    if (pageNo == null || pageSize == null || search == null) {
      throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
    }
    Map<String, Object> result = fileService.getFileList(pageNo, pageSize, search);
    List<SysFile> list = (List<SysFile>) result.get("list");
    List<Map<String, Object>> resultList = new ArrayList<>();
    for (SysFile file : list) {
      Map<String, Object> map = new HashMap<>();
      map.put("id", file.getId());
      map.put("fileName", file.getFileName());
      map.put("fileSize", ossService.getFileContent(file.getObsPath(), bucketName).length);
      map.put("filePath", file.getObsPath());
      map.put("createTime", file.getCreateTime());
      map.put("updateTime", file.getUpdateTime());
      resultList.add(map);
    }
    return R.ok().ext(result.get("ext")).data(resultList);
  }


  @Log(value = "删除文件")
  @DeleteMapping(value = "/delete")
  public R delFile(Long id) {
    if (id == null) {
      throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
    }
    SysFile file = fileService.getFileInfo(id);
    VoidResult result = ossService.deleteFile(file.getObsPath(), bucketName);
    if (result.getResponse().getErrorResponseAsString() == null) {
      fileService.deleteFile(id);
      return R.ok();
    } else {
      throw new ServiceException(ExceptionCode.FILE_DELETE_ERROR);
    }
  }

  @Log(value = "获取文件内容")
  @GetMapping(value = "/info")
  public R getInfo(String filePath) throws IOException {
    if (filePath == null) {
      throw new ServiceException(ExceptionCode.PARAMTER_ERROR);
    }
    byte[] fileContent = ossService.getFileContent(filePath, bucketName);
    String content = Base64.getEncoder().encodeToString(fileContent);
    return R.ok().data(content);
  }
}
