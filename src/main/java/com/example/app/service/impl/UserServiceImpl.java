package com.example.app.service.impl;

import com.example.app.dao.UserMapper;
import com.example.app.domain.User;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String id) {

        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertUser(User user) {

        return userMapper.insert(user);
    }
}
