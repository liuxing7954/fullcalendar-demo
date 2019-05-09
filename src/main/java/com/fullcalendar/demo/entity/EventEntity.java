package com.fullcalendar.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "userevent")
@Data
public class EventEntity {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    private int userId;
    private String title;
    private String eventType;
    private boolean repeatFlag;
    private String repeatType;
    private String start;
    private String end;
    private String city;
    private String weather;

}
