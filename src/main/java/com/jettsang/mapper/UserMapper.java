package com.jettsang.mapper;

import com.jettsang.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{name}")
    User findByUserName(String name);

    @Insert("insert into user(username,password,create_time,update_time)"+ " values(#{username},#{md5PWD},now(),now())")
    void add(String username ,String md5PWD);
}
