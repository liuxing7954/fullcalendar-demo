package com.fullcalendar.demo.dao;

import com.fullcalendar.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
    UserEntity getUserEntityByUsername(String name);
}
