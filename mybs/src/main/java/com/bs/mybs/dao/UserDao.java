package com.bs.mybs.dao;

import com.bs.mybs.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface UserDao {

    @Select("select * from user")
    public List<User> findAll();
}
