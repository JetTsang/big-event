package com.jettsang.service.impl;

import com.jettsang.mapper.UserMapper;
import com.jettsang.pojo.User;
import com.jettsang.service.UserService;
import org.springframework.stereotype.Service;

// 先塞到Aoc里面，controller里面就可以引入了
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Override
    public User findByUserName(String name) {
//        TODO： 找到mapper里的方法去调用
        User u = userMapper.findByUserName(name)
        return u;
    }

    @Override
    public void register(String name, String pwd) {
//    TODO: 加密
//        TODO：调用mapper方法去插入
    }
}
