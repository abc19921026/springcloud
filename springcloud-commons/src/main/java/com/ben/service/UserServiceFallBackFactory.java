package com.ben.service;

import com.ben.pojo.model.UserDO;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceFallBackFactory implements FallbackFactory {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public UserDO queryById(Integer id) {
                return new UserDO().setId(id)
                        .setRemark("这个id=>"+id+",没有对应的信息,null---@Hystrix~");
            }

            @Override
            public List<UserDO> queryAll() {
                return null;
            }

            @Override
            public Boolean insert(UserDO userDO) {
                return null;
            }
        };
    }
}
