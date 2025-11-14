package com.ms.hms.common.config;

//import com.aliyun.oss.ClientBuilderConfiguration;
//import com.aliyun.oss.OSS;
//import com.aliyun.oss.common.auth.CredentialsProviderFactory;
//import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyun.oss.*;
import com.aliyun.oss.OSS;
import com.aliyun.oss.common.auth.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OssConfig {


  @Value("${aliyun.endpoint}")
  private String endpoint;

  @Value("${aliyun.accessKeyId}")
  private String accessKeyId;

  @Value("${aliyun.accessKeySecret}")
  private String accessKeySecret;

  @Value("${aliyun.bucketName}")
  private String bucketName;

  @Value("${aliyun.region}")
  private String region;

  @Value("${aliyun.urlPrefix}")
  private String urlPrefix;


  @Bean
  public OSSClient ossClient() throws Exception {
    // 创建OSSClient实例。
    ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
    clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
    return (OSSClient) OSSClientBuilder.create()
        .endpoint(endpoint)
        .credentialsProvider(new DefaultCredentialProvider(accessKeyId, accessKeySecret))
        .clientConfiguration(clientBuilderConfiguration)
        .region(region)
        .build();
  }

}
