package com.ms.hms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.hms.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<SysUser> {

    void changePwd(@Param("id") Long id , @Param("password") String password, @Param("update_time") Long updateTime);

}
