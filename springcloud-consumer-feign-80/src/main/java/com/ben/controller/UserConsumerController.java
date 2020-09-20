package com.ben.controller;

import com.ben.pojo.model.UserDO;
import com.ben.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer/user")
public class UserConsumerController {

    @Autowired
    private UserService userService;

    @GetMapping("/queryById/{id}")
    public UserDO queryById(@PathVariable("id") Integer id){
        return  userService.queryById(id);
    }

    @PostMapping("/add")
    public boolean add(UserDO userDO){
        return userService.insert(userDO);
    }


}
