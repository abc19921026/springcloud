package com.ben.service.impl;

import com.ben.mapper.UserMapper;
import com.ben.pojo.model.UserDO;
import com.ben.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean insert(UserDO userDO) {
        int i = userMapper.insert(userDO);
        return i > 0;
    }

    @Override
    public UserDO queryById(Integer id) {
        return userMapper.queryById(id);
    }

    @Override
    public List<UserDO> queryAll() {
        return userMapper.queryAll();
    }
}
