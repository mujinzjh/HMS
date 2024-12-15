package com.ms.hms.controller;


import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import com.ms.hms.common.result.R;
import com.ms.hms.common.utils.FileUtils;
import com.ms.hms.entity.Param.MergeParam;
import com.ms.hms.exception.ExceptionCode;
import com.ms.hms.exception.ServiceException;

import com.ms.hms.service.OSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaojianhua
 */
@RestController
@RequestMapping(value = "/upload")
public class UploadController {
  @Autowired
  private OSSClient ossClient ;

  @Autowired
  private OSSService ossService ;


  @Value("${aliyun.bucketName}")
  private String bucketName;

  @GetMapping("/getUploadId")
  public R getUploadId(String fileName) {
    String filePath = FileUtils.getFullPath(fileName);
    String uploadId = ossService.getUploadId(filePath);
    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("uploadId", uploadId);
    resultMap.put("obsPath", filePath);
    return R.ok().data(resultMap);
  }

  @PostMapping ("/part")
  public R partUpload(@RequestParam String filePath, @RequestParam String uploadId,
                      @RequestParam("partNumber") int partNumber, @RequestParam("file") MultipartFile file) {
    try {
      InputStream inputStream = file.getInputStream();
      PartETag partETag = ossService.uploadFilePart(inputStream,bucketName,uploadId, filePath,partNumber);
      return R.ok().data(partETag);
    } catch (Exception e) {
      throw new ServiceException(ExceptionCode.PART_UPLOAD_FAIL);
    }
  }

  @PostMapping ("/merge")
  public R mergeFile(@RequestBody MergeParam mergeParam) {
    try {
      ossService.mergeUpload(mergeParam.getUploadId(), mergeParam.getFilePath(),bucketName, mergeParam.getPartETags());
      return R.ok();
    }catch (Exception e) {
      throw new ServiceException(ExceptionCode.MERGE_FILE_FAIL);
    }
  }


  @PostMapping("/uploadFile")
  public R uploadFile(@RequestParam("file") MultipartFile file) {
    try {
      String filePath = file.getOriginalFilename();
      String objectName =  FileUtils.getFullPath(filePath);
      InputStream inputStream = file.getInputStream();
      ossService.uploadFile(inputStream,objectName, bucketName);
      return R.ok();
  } catch (Exception e) {
      throw new ServiceException(ExceptionCode.FILE_UPLOAD_FAIL);}
  }
}
