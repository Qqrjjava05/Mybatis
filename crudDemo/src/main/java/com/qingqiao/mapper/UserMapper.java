package com.qingqiao.mapper;

import com.qingqiao.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> queryAll();

    User queryById(Integer id);

    int delete(Integer id);

    int update(User user);

    int insert(User user);

}
