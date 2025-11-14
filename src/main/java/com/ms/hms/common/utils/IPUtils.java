package com.ms.hms.common.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class IPUtils {
  private static final Logger log = LogManager.getLogger(IPUtils.class);

  private static String DB_PATH;

  @Value("${ip2region.location}")
  public void setIpLocation(String DB_PATH) {
    IPUtils.DB_PATH = DB_PATH;
  }
  private static final ThreadLocal<Searcher> searcherThreadLocal = ThreadLocal.withInitial(() -> {
    try {
      return Searcher.newWithFileOnly(DB_PATH);
    } catch (Exception e) {
      log.error("初始化 IP 归属地查询失败: {}", e.getMessage());
      return null;
    }
  });
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

  public static String getCityInfo(String ip) {
    Searcher searcher = searcherThreadLocal.get();
    if (searcher == null) {
      return null;
    }

    try {
      long startTime = System.nanoTime();
      String region = searcher.search(ip);
      long cost = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
      log.info("IP: {}, Region: {}, IO Count: {}, Took: {} μs", ip, region, searcher.getIOCount(), cost);
      return region;
    } catch (Exception e) {
      log.error("IP: {} 获取 IP 归属地错误，错误原因: {}", ip, e.getMessage());
      return null;
    } finally {
      closeSearcher();
    }
  }

  public static void closeSearcher() {
    try {
      Searcher searcher = searcherThreadLocal.get();
      if (Objects.nonNull(searcher)) {
        searcher.close();
        searcherThreadLocal.remove();
      }
    } catch (Exception e) {
      log.error("关闭异常", e);
    }
  }
}
