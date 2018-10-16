package com.example.app.dao;

import com.example.app.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String loginId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String loginId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}