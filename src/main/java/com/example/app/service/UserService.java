package com.example.app.service;

import com.example.app.domain.User;
import org.apache.ibatis.annotations.Mapper;

public interface UserService {
    User getUserById(String id);
    int insertUser(User user);
}
