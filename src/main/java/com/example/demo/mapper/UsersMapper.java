package com.example.demo.mapper;

import com.example.demo.model.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Select("select * from user")
    List<Users> findAll();

    @Insert("insert into users(name,salary) values(#{name},#{salary})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void insert(Users users);

    @Update("update users set salary=#{salary} where name=#{name}")
    void update(Users users);

    @Delete("delete from users where name=#{name}")
    void delete(Users users);
}
