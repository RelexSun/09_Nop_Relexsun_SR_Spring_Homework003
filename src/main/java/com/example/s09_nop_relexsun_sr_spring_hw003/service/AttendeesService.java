package com.example.s09_nop_relexsun_sr_spring_hw003.service;

import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request.AttendeesRequest;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Attendee;

import java.util.List;

public interface AttendeesService {
    List<Attendee> getAllAttendees(Integer page, Integer size);

    Attendee getAttendeesById(Long attendeesId);

    Attendee createAttendee(AttendeesRequest req);
    Attendee updateAttendee(Long attendeesId, AttendeesRequest request);
    Attendee deleteAttendee(Long attendeesId);
}

