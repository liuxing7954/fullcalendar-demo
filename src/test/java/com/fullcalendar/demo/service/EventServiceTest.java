package com.fullcalendar.demo.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonParser;
import com.fullcalendar.demo.entity.EventEntity;
import com.fullcalendar.demo.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.JSONString;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class EventServiceTest {

    @Autowired
    EventService service;
    @Test
    public void addEvent() {
        int userId = 2;
        String title = "玩电脑玩电脑！！！";
        String eventType = "生活";
        boolean repeat = true;
        String repeatType = "adasd";
        String start = "2019-05-08";
        String end = "2019-05-09";
        String city = "合肥";
        EventEntity entity = service.addEvent(userId,title,eventType,repeat,repeatType,start,end,city);
        Assert.assertNotNull("添加日程失败",entity);
        log.info("结果集{}", JSON.toJSONString(entity));
    }

    @Test
    public void removeEvent() {
        int eventId = 2;
        boolean b = service.removeEvent(eventId);
        Assert.assertTrue("删除失败",b);
    }

    @Test
    public void getEvents() {
        int userId = 22;
        List<EventEntity> events = service.getEvents(userId);
        log.info("结果集{}", JSON.toJSONString(events));
        Assert.assertNotEquals("查询事件失败",0,events.size());
    }

    @Test
    public void getEventsByTitle() {
        String title="测试";
        List<EventEntity> events = service.getEventsByTitle(title);
        log.info("结果集{}", JSON.toJSONString(events));
        Assert.assertNotEquals("查询事件失败",0,events.size());
        title="时间";
        events = service.getEventsByTitle(title);
        log.info("结果集{}", JSON.toJSONString(events));
        Assert.assertNotEquals("查询事件失败",0,events.size());
        title="时";
        events = service.getEventsByTitle(title);
        log.info("结果集{}", JSON.toJSONString(events));
        Assert.assertNotEquals("查询事件失败",0,events.size());
        title="脑";
        events = service.getEventsByTitle(title);
        log.info("结果集{}", JSON.toJSONString(events));
        Assert.assertNotEquals("查询事件失败",0,events.size());
    }
}