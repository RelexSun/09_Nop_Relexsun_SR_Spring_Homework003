package com.example.s09_nop_relexsun_sr_spring_hw003.service;

import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request.EventRequest;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvent(Integer page, Integer size);

    Event getEventById(Long eventId);

    Event createEvent(EventRequest request);

    Event updateEvent(Long eventId, EventRequest request);

    Event deleteEventById(Long eventId);
}
