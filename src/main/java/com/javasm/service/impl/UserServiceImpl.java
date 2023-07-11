package com.javasm.service.impl;

import com.javasm.entity.User;
import com.javasm.mapper.UserMapper;
import com.javasm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author zk
 * @Date 2023/7/10 15:40
 * @注释：
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public void remove(int id) {
        userMapper.delete(id);
    }

    @Override
    public void edit(User user) {
        userMapper.update(user);
    }

    @Override
    public User queryById(int id) {
        User user = userMapper.selectById(id);
        return user;
    }
}
