package com.ms.hms.common.utils;

import com.ms.hms.Interceptor.TokenInterceptor;
import com.ms.hms.common.Constants;
import com.ms.hms.entity.SysUser;

public class FileUtils {
  public static String getFullPath(String fileName) {
    SysUser user = TokenInterceptor.THREAD_LOCAL.get();
    return Constants.ROOT_FILE_PATH + '/' + user.getId() + '/' + fileName;
  }



}
