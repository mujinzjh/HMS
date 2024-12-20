package com.ms.hms.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import com.ms.hms.Interceptor.TokenInterceptor;
import com.ms.hms.common.utils.FileUtils;
import com.ms.hms.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

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

  public PutObjectResult uploadFile(InputStream inputStream, String filePath, String bucketName){
    PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, filePath, inputStream);
    // 创建PutObject请求。
    return ossClient.putObject(putObjectRequest);
  }

  public void deleteFile(String filePath, String bucketName){
    ossClient.deleteObject(bucketName, filePath);
  }

  public byte[] getFileContent(String filePath, String bucketName) throws IOException {
    OSSObject ossObject = ossClient.getObject(bucketName, filePath);
    InputStream inputStream = ossObject.getObjectContent();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] readBuffer = new byte[1024];
    int bytesRead;
    while ((bytesRead = inputStream.read(readBuffer)) != -1) {
      byteArrayOutputStream.write(readBuffer, 0, bytesRead);
    }
    return byteArrayOutputStream.toByteArray();
  }

  public URL getFileUrl(String filePath, String bucketName){
    Date expiration = new Date(new Date().getTime() + 3600 * 1000L);
    // 生成以GET方法访问的签名URL。本示例没有额外请求头，其他人可以直接通过浏览器访问相关内容。
    return ossClient.generatePresignedUrl(bucketName, filePath, expiration);
  }

  public List<Map<String, Object>> getFileList(String filePath, String bucketName){
    List<Map<String, Object>> fileList = new ArrayList<>();
    ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
    // 设置prefix参数来获取fun目录下的所有文件。
    listObjectsRequest.setPrefix(filePath);
    listObjectsRequest.setDelimiter("/");
    ObjectListing list = ossClient.listObjects(listObjectsRequest);
    System.out.println("=============");

    System.out.println(list);
    for (OSSObjectSummary objectSummary : list.getObjectSummaries()) {
      Map<String, Object> resultMap = new HashMap<>();
      resultMap.put("type", 1);
      resultMap.put("name", FileUtils.getFileName(objectSummary.getKey()));
      resultMap.put("path", objectSummary.getKey());
      resultMap.put("size", FileUtils.getFileSize(objectSummary.getSize()));
      fileList.add(resultMap);
    }
    for (String commonPrefix : list.getCommonPrefixes()) {
      Map<String, Object> resultMap = new HashMap<>();
      resultMap.put("type", 0);
      resultMap.put("name", FileUtils.getDirName(commonPrefix));
      resultMap.put("path", commonPrefix);
      resultMap.put("size", 0);
      fileList.add(resultMap);
    }
    return fileList;
  }
}
