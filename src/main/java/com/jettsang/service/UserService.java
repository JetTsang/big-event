package com.jettsang.service;

import com.jettsang.pojo.User;

public interface UserService {
    public User findByUserName(String name);
    public void register(String name , String pwd);
}
