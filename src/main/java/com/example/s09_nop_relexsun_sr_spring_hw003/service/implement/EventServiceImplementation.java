package com.example.s09_nop_relexsun_sr_spring_hw003.service.implement;

import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request.EventRequest;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Event;
import com.example.s09_nop_relexsun_sr_spring_hw003.repository.EventAttendeesRepository;
import com.example.s09_nop_relexsun_sr_spring_hw003.repository.EventRepository;
import com.example.s09_nop_relexsun_sr_spring_hw003.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImplementation implements EventService {
    private final EventRepository eventRepository;
    private final EventAttendeesRepository eventAttendeesRepository;

    @Override
    public List<Event> getAllEvent(Integer page, Integer size) {
        return this.eventRepository.getAllEvent(page, size);
    }

    @Override
    public Event getEventById(Long eventId) {
        return this.eventRepository.getEventById(eventId);
    }

    @Override
    public Event createEvent(EventRequest request) {
        Event event = this.eventRepository.createEvent(request);
        for(Long attendee_id : request.getAttendeesId()) {
            eventAttendeesRepository.createEventAttendees(event.getEventId(), attendee_id);
        }
        return getEventById(event.getEventId());
    }

    @Override
    public Event updateEvent(Long eventId, EventRequest request) {
        Event event = this.eventRepository.updateEvent(eventId, request);
        eventAttendeesRepository.deleteEventAttendees(eventId);
        for(Long attendee_id : request.getAttendeesId()) {
            eventAttendeesRepository.createEventAttendees(event.getEventId(), attendee_id);
        }
        return getEventById(event.getEventId());
    }

    @Override
    public Event deleteEventById(Long eventId) {
        return this.eventRepository.deleteEventById(eventId);
    }
}
