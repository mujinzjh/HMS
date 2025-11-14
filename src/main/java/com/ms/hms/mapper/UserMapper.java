package com.ms.hms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.hms.entity.Param.UserParam;
import com.ms.hms.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<SysUser> {

    void changePwd(@Param("id") Long id, @Param("password") String password, @Param("update_time") Long updateTime);

    int getUserCount(Map searchMap);

    List<SysUser> getUserList(Map searchMap);

    List<SysUser> getUserData(Map searchMap);

    void updateUser(Long id, String des, String email, String username, LocalDateTime currentTimeMillis);

    void deleteById(Long id);
}
