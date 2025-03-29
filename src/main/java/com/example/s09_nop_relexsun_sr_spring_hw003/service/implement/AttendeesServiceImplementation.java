package com.example.s09_nop_relexsun_sr_spring_hw003.service.implement;

import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request.AttendeesRequest;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Attendee;
import com.example.s09_nop_relexsun_sr_spring_hw003.repository.AttendeesRepository;
import com.example.s09_nop_relexsun_sr_spring_hw003.service.AttendeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendeesServiceImplementation implements AttendeesService {
    private final AttendeesRepository attendeesRepository;

    @Override
    public List<Attendee> getAllAttendees(Integer page, Integer size) {
        return this.attendeesRepository.getAllAttendees(page, size);
    }

    @Override
    public Attendee getAttendeesById(Long attendeesId) {
        return this.attendeesRepository.getAttendeesById(attendeesId);
    }

    @Override
    public Attendee createAttendee(AttendeesRequest req) {
        return this.attendeesRepository.createAttendee(req);
    }

    @Override
    public Attendee updateAttendee(Long attendeesId, AttendeesRequest request) {
        return this.attendeesRepository.updateAttendee(attendeesId, request);
    }

    @Override
    public Attendee deleteAttendee(Long attendeesId) {
        return this.attendeesRepository.deleteAttendee(attendeesId);
    }
}
