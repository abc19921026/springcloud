package com.ben.mapper;

import com.ben.pojo.model.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    int insert(UserDO userDO);

    UserDO queryById(Integer id);

    List<UserDO> queryAll();
}
