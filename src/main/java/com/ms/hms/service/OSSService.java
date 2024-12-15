package com.ms.hms.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import com.ms.hms.Interceptor.TokenInterceptor;
import com.ms.hms.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OSSService {

  @Autowired
  private OSSClient ossClient ;

  @Autowired
  private SysFileService sysFileService ;

  @Value("${aliyun.bucketName}")
  private String bucketName;

  public String getUploadId(String filePath){
    InitiateMultipartUploadRequest request = new InitiateMultipartUploadRequest(bucketName, filePath);
    InitiateMultipartUploadResult upresult = ossClient.initiateMultipartUpload(request);
    return upresult.getUploadId();
  }

  public PartETag uploadFilePart(InputStream inputStream, String bucketName, String uploadId , String filePath, int partNumber){
    UploadPartRequest uploadPartRequest = new UploadPartRequest();
    uploadPartRequest.setBucketName(bucketName);
    uploadPartRequest.setUploadId(uploadId);
    uploadPartRequest.setKey(filePath);
    uploadPartRequest.setPartNumber(partNumber);
    uploadPartRequest.setInputStream(inputStream);
    UploadPartResult uploadPartResult = ossClient.uploadPart(uploadPartRequest);
    return uploadPartResult.getPartETag();
  }

  public void mergeUpload(String uploadId, String filePath, String bucketName, List<Map<String, Object>> partETags){
    try {
      List<PartETag> partETagList = new ArrayList<PartETag>();
      for (Map<String, Object> partItem : partETags) {
        int partNumber = (int) partItem.get("partNumber");
        String eTag = (String) partItem.get("etag");
        PartETag partETag = new PartETag(partNumber, eTag);
        partETagList.add(partETag);
      }
      CompleteMultipartUploadRequest request =
          new CompleteMultipartUploadRequest(bucketName, filePath, uploadId, partETagList);
      CompleteMultipartUploadResult completeMultipartUploadResult = ossClient.completeMultipartUpload(request);
      SysUser user = TokenInterceptor.THREAD_LOCAL.get();
      String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
      sysFileService.saveFile(user.getId(), filePath, completeMultipartUploadResult.getLocation(), fileName);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void uploadFile(InputStream inputStream, String filePath, String bucketName){
    PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, filePath, inputStream);
    // 创建PutObject请求。
    PutObjectResult result = ossClient.putObject(putObjectRequest);
  }
}
