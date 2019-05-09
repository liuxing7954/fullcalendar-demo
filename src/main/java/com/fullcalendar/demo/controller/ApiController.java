package com.fullcalendar.demo.controller;

import com.alibaba.fastjson.JSON;
import com.fullcalendar.demo.entity.EventEntity;
import com.fullcalendar.demo.entity.UserEntity;
import com.fullcalendar.demo.service.EventService;
import com.fullcalendar.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    UserService userService;
    @Autowired
    EventService eventService;


    @RequestMapping("/login")
    public String login(@Autowired HttpServletRequest request, String username, String pass) {
        UserEntity entity = userService.signIn(username, pass);
        if (entity != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", entity.getId());
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/isLogin")
    public String isLogin(@Autowired HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("userId") != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/getEvents")
    public String getEvents(@Autowired HttpServletRequest request) {
        int userId = getUserIdFromSession(request);
        List<EventEntity> events = eventService.getEvents(userId);
        return JSON.toJSONString(events);
    }

    @RequestMapping("/addEvent")
    public String addEvent(@Autowired HttpServletRequest request, String title, String eventType, boolean repeatFlag, String repeatType, String start, String end, String city) {
        int userId = getUserIdFromSession(request);
        EventEntity entity = eventService.addEvent(userId, title, eventType, repeatFlag, repeatType, start, end, city);
        if (entity != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/removeEvent")
    public String removeEvent(int eventId) {
        boolean b = eventService.removeEvent(eventId);
        if (b) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/searchEvent")
    public String searchEvent(String title) {
        List<EventEntity> events = eventService.getEventsByTitle(title);
        return JSON.toJSONString(events);
    }

    private int getUserIdFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = session.getAttribute("userId").toString();
        return Integer.valueOf(userId);
    }
}
