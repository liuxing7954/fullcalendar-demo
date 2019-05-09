package com.fullcalendar.demo.service;

import com.fullcalendar.demo.dao.EventDao;
import com.fullcalendar.demo.entity.EventEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EventService {

    @Autowired
    private EventDao dao;
    public EventEntity addEvent(int userId, String title, String eventType, boolean repeat, String repeatType, String start,String end, String city){
        EventEntity entity = new EventEntity();
        entity.setUserId(userId);
        entity.setTitle(title);
        entity.setEventType(eventType);
        entity.setRepeatFlag(repeat);
        entity.setRepeatType(repeatType);
        entity.setStart(start);
        entity.setEnd(end);
        entity.setCity(city);
        entity.setWeather(city);
        return dao.save(entity);
    }

    public boolean removeEvent(int eventId){
        EventEntity entity = dao.getOne(eventId);
        if(entity == null)
            return false;
        dao.delete(entity);
        return true;
    }
    public List<EventEntity> getEvents(int userId){
        List<EventEntity> entities = dao.getEventEntitiesByUserId(userId);
        return entities;
    }

    public List<EventEntity> getEventsByTitle(String title){
        return dao.getEventEntitiesByTitleContains(title);
    }

}
