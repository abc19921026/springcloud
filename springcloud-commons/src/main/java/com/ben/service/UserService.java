package com.ben.service;

import com.ben.pojo.model.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
//@FeignClient:微服务客户端注解,value:指定微服务的名字,
// 这样就可以使Feign客户端直接找到对应的微服务
@FeignClient(value = "SPRINGCLOUD-PROVIDER",fallbackFactory = UserServiceFallBackFactory.class)
public interface UserService {

    @GetMapping("/user/queryById/{id}")
    public UserDO queryById(@PathVariable("id")Integer id);

    @GetMapping("/user/queryAll")
    public List<UserDO> queryAll();

    @PostMapping("/user/add")
    public Boolean insert(UserDO userDO);

}
