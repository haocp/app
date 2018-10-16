package com.example.app.controller;

import com.example.app.domain.User;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@RestController
@RequestMapping("/login")
@SpringBootApplication //Spring Boot核心注解，用于开启自动配置
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    /**
     * 根据ID查询人员信息
     *
     * @param id
     * @return
     */
    @GetMapping("/getUserById")
    public User getUserByName(@RequestParam(name = "id") String id) {
        System.out.println("-------------" + id);
        User user = userService.getUserById(id);
        System.out.println("+++++++++" + user);
        return user;
    }

    /**
     * 注册 返回1：成功
     *
     * @param user
     * @return
     */
    @PostMapping("/insertUser")
    public void insertUser(@RequestBody User user, HttpServletResponse response) throws IOException {
        try {
            int i = userService.insertUser(user);
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/insertUsers")
    public void insertUsers(@RequestBody User user) throws IOException {
        System.out.println("------1111"+user);
    }
}
