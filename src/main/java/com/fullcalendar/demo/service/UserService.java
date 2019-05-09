package com.fullcalendar.demo.service;

import com.fullcalendar.demo.dao.UserDao;
import com.fullcalendar.demo.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserDao dao;

    public UserEntity signUp(String username, String pass, String nickname) {
        if(dao.getUserEntityByUsername(username) != null){
            log.info("已被注册");
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.setUsername(username);
        entity.setPass(pass);
        entity.setNickname(nickname);
        return dao.save(entity);
    }

    public UserEntity signIn(String username, String pass) {
        UserEntity entity = dao.getUserEntityByUsername(username);
        if(entity == null){
            return null;
        }
        if(entity.getPass().equals(pass)){
            return entity;
        }else{
            return null;
        }
    }


}
