package com.javasm.mapper;

import com.javasm.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @Author zk
 * @Date 2023/7/10 15:39
 * @注释：CRUD
 */
public interface UserMapper {

    @Insert("INSERT INTO tb_user VALUES(#{id},#{userName},#{birthday},#{gender},#{address})")
    void insert(User user);

    @Delete("DELETE FROM tb_user WHERE id=#{id}")
    void delete(int id);

    @Update("UPDATE tb_user SET user_name=#{userName},address=#{address} WHERE id=#{id} ")
    void update(User user);

    @Select("SELECT * FROM tb_user where id=#{id}")
    User selectById(int id);
}
