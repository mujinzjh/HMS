package com.ms.hms.common;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static String BASE_URL = "/hms";//基础结果

    //token过期时间
    public static long USER_TOKEN_EXPIRE = 2 * 60 * 60;

    public static long LOGIN_LOG = 2;
    public static long OPERATION_LOG = 1;

    //成功的状态码
    public static String SUCCESS_CODE = "200";

    public static String DEFAULT_PASSWORD = "111111";

    public static String ROOT_FILE_PATH = "hms_data";
}
