package com.ms.hms.common.utils;

import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class IPUtils {
  /**
   * 获取http请求ip
   * @param request
   * @return ipAddress
   */
  public static String getIpAddr(HttpServletRequest request) {
    String ipAddress ;
    try {
      ipAddress = request.getHeader("x-forwarded-for");
      if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
        ipAddress = request.getHeader("Proxy-Client-IP");
      }
      if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
        ipAddress = request.getHeader("WL-Proxy-Client-IP");
      }
      if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
        ipAddress = request.getRemoteAddr();
        if (ipAddress.equals("127.0.0.1")) {
          // 根据网卡取本机配置的IP
          InetAddress inet = null;
          try {
            inet = InetAddress.getLocalHost();
          } catch (UnknownHostException e) {
            e.printStackTrace();
          }
          assert inet != null;
          ipAddress = inet.getHostAddress();
        }
      }
      // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
      if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
        // = 15
        if (ipAddress.indexOf(",") > 0) {
          ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }
      }
    } catch (Exception e) {
      ipAddress="";
    }
    // ipAddress = this.getRequest().getRemoteAddr();
    return ipAddress;
  }

  public String getCityInfo(String ip)  {
    try {
      String dbPath = Objects.requireNonNull(this.getClass().getClassLoader().getResource("ip2region.db")).getPath();
      DbSearcher searcher = new DbSearcher(new DbConfig(), dbPath);
      //查询算法
      //B-tree, B树搜索（更快）
      int algorithm = DbSearcher.BTREE_ALGORITHM;
      //define the method
      Method method;
      method = searcher.getClass().getMethod("btreeSearch", String.class);
      DataBlock dataBlock;
      if (!Util.isIpAddress(ip)) {
        System.out.println("Error: Invalid ip address");
      }
      dataBlock = (DataBlock) method.invoke(searcher, ip);
      String ipInfo = dataBlock.getRegion();
      if (ipInfo != null) {
        ipInfo = ipInfo.replace("|0", "");
        ipInfo = ipInfo.replace("0|", "");
      }
      return ipInfo;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  /**
   * 获取IP属地
   * @param ip
   */
  public String getIpPossession(String ip) {
    String cityInfo = getCityInfo(ip);
    if (cityInfo != null) {
      cityInfo = cityInfo.replace("|", " ");
      String[] cityList = cityInfo.split(" ");
      if (cityList.length > 0) {
        // 国内的显示到具体的省
        if ("中国".equals(cityList[0])) {
          if (cityList.length > 1) {
            return cityList[0]+"-"+cityList[1]+"-"+cityList[2];
          }
        }
        // 国外显示到国家
        return cityList[0];
      }
    }
    return "未知";
  }
}
