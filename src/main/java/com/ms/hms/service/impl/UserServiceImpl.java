package com.ms.hms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.hms.entity.SysUser;
import com.ms.hms.mapper.UserMapper;
import com.ms.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,SysUser> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public SysUser findById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public SysUser findByName(String username) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUsername,username);
        List<SysUser> _list = userMapper.selectList(queryWrapper);
        return _list.size()>0? _list.get(0) : null;
    }

}
