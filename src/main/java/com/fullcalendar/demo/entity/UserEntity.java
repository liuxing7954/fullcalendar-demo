package com.fullcalendar.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class UserEntity {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    private String username;
    private String pass;
    private String nickname;
}
