package com.javasm.controller;

import com.javasm.entity.User;
import com.javasm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author zk
 * @Date 2023/7/10 15:39
 * @注释：
 */
//@RestController //相当于@Controller和@ResponseBody
@Controller
@ResponseBody
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("add")
    public String addUser(@RequestBody User user) {
        System.out.println("user: " + user);
        userService.add(user);
        return "add success";
    }

    @GetMapping("query")
    public User query(int id) {
        User user = userService.queryById(id);
        return user;
    }
}
