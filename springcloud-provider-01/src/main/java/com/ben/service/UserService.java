package com.ben.service;

import com.ben.pojo.model.UserDO;

import java.util.List;

public interface UserService {

    Boolean insert(UserDO userDO);

    UserDO queryById(Integer id);

    List<UserDO> queryAll();
}
