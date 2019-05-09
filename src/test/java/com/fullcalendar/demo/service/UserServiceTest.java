package com.fullcalendar.demo.service;

import com.fullcalendar.demo.DemoApplication;
import com.fullcalendar.demo.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    UserService service;
    @Test
    public void signUp() {
        String username = "admin";
        String pass = "admin";
        String nickname = "管理员";
        UserEntity entity = service.signUp(username, pass, nickname);
        Assert.assertNotNull("注册失败",entity);
    }
    @Test
    public void signIn() {
        String username = "admin";
        String pass = "admin";
        UserEntity entity = service.signIn(username, pass);
        Assert.assertNotNull("登陆失败",entity);

    }
}