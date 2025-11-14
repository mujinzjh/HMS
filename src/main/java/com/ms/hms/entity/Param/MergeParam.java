package com.ms.hms.entity.Param;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MergeParam {
  private List<Map<String, Object>> partETags;

  private String filePath;

  private String uploadId;
}
