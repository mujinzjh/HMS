package com.ms.hms.common.utils;

import com.ms.hms.Interceptor.TokenInterceptor;
import com.ms.hms.common.Constants;
import com.ms.hms.entity.SysUser;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
  public static String getFullPath(String fileName) {
    SysUser user = TokenInterceptor.THREAD_LOCAL.get();
    return Constants.ROOT_FILE_PATH + '/' + user.getId() + '/' + fileName;
  }

  public static String getFileName(String filePath) {
    Path path = Paths.get(filePath);
    return path.getFileName().toString();
  }

  public static String getDirName(String filePath) {
    String fileName = getFileName(filePath);
    return getFileName(fileName);
  }

  public static String getFileSize(long bytes) {
    System.out.println("字节数: " + bytes + " B");
    if (bytes < 1024) {
      return bytes + " B";
    } else if (bytes < 1024 * 1024) {
      return convertBytesToKilobytes(bytes) + " KB";
    } else if (bytes < 1024 * 1024 * 1024) {
      return convertBytesToMegabytes(bytes) + " MB";
    } else if (bytes < 1024 * 1024 * 1024 * 1024) {
      return convertBytesToGigabytes(bytes) + " GB";
    } else {
      return convertBytesToTerabytes(bytes) + " TB";
    }
  }

  private static double convertBytesToKilobytes(long bytes) {
    return bytes / 1024.0;
  }

  private static double convertBytesToMegabytes(long bytes) {
    return convertBytesToKilobytes(bytes) / 1024.0;
  }

  private static double convertBytesToGigabytes(long bytes) {
    return convertBytesToMegabytes(bytes) / 1024.0;
  }

  private static double convertBytesToTerabytes(long bytes) {
    return convertBytesToGigabytes(bytes) / 1024.0;
  }
}
