package com.javasm.setivce;

import com.javasm.entity.User;

/**
 * @Author zk
 * @Date 2023/7/10 15:40
 * @注释：
 */
public interface UserService {
    void add(User user);

    void remove(int id);

    void edit(User user);

    User queryById(int id);
}
