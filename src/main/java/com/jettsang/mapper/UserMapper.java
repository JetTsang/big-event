package com.jettsang.mapper;

import com.jettsang.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * form user where username=#{username}")
    User findByUserName(String name);

    @Insert("insert into user(username,password,create_time,update_time)"+ " values(#{usrename},#{md5PWD},now(),now())")
    void add(String username ,String md5PWD);
}
