package com.fullcalendar.demo.dao;

import com.fullcalendar.demo.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventDao extends JpaRepository<EventEntity,Integer> {
    List<EventEntity> getEventEntitiesByUserId(int userId);
    List<EventEntity> getEventEntitiesByTitleContains(String title);
}
