package com.example.s09_nop_relexsun_sr_spring_hw003.controller;

import com.example.s09_nop_relexsun_sr_spring_hw003.exception.NotFoundException;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request.EventRequest;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.response.APIResponse;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Attendee;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Event;
import com.example.s09_nop_relexsun_sr_spring_hw003.service.implement.AttendeesServiceImplementation;
import com.example.s09_nop_relexsun_sr_spring_hw003.service.implement.EventServiceImplementation;
import com.example.s09_nop_relexsun_sr_spring_hw003.service.implement.VenueServiceImplementation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class EventController {
    private final EventServiceImplementation eventServiceImplementation;
    private final AttendeesServiceImplementation attendeesServiceImplementation;
    private final VenueServiceImplementation venueServiceImplementation;

    @GetMapping
    public ResponseEntity< APIResponse<List<Event>>> getAllEvent(@RequestParam(defaultValue = "1") @Positive Integer page, @RequestParam(defaultValue = "10") @Positive Integer size) {
        page = (page - 1) * size;
        List<Event> events = this.eventServiceImplementation.getAllEvent(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(APIResponse.<List<Event>>builder()
                .message("All events successfully fetched.")
                .payload(events)
                .status(HttpStatus.OK)
                .timestamp(Instant.now())
                .build());
    }

    @GetMapping("/{event-id}")
    public ResponseEntity<APIResponse<Event>> getEventById(@PathVariable("event-id") Long eventId) {
        Event event = this.eventServiceImplementation.getEventById(eventId);
        if(event == null) throw new NotFoundException("Event "+eventId+" not found.");
        return ResponseEntity.status(HttpStatus.OK).body(APIResponse.<Event>builder()
                .message("Event successfully fetched.")
                .payload(event)
                .status(HttpStatus.OK)
                .timestamp(Instant.now())
                .build());
    }

    @PostMapping
    public ResponseEntity<APIResponse<Event>> createEvent(@RequestBody @Valid EventRequest request) {
        Event event = this.eventServiceImplementation.createEvent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(APIResponse.<Event>builder()
                .message("Event successfully created.")
                .payload(event)
                .status(HttpStatus.CREATED)
                .timestamp(Instant.now())
                .build());
    }

    @PutMapping("/{event-id}")
    public ResponseEntity<APIResponse<Event>> updateEvent(@PathVariable("event-id") Long eventId, @RequestBody @Valid EventRequest request) {
        if(this.venueServiceImplementation.getVenueById(request.getVenueId()) == null) throw new NotFoundException("Venue "+ request.getVenueId() +" not found.");
        for(Long attendeeId : request.getAttendeesId()) {
            Attendee attendee = this.attendeesServiceImplementation.getAttendeesById(attendeeId);
            if(attendee == null) throw new NotFoundException("Attendee "+attendeeId+" not found.");
        }
        Event event = this.eventServiceImplementation.updateEvent(eventId, request);
        if(event == null) throw new NotFoundException("Event "+eventId+" not found.");
        return ResponseEntity.status(HttpStatus.OK).body(APIResponse.<Event>builder()
                .message("Event successfully updated.")
                .payload(event)
                .status(HttpStatus.OK)
                .timestamp(Instant.now())
                .build());
    }

    @DeleteMapping("/{event-id}")
    public ResponseEntity<APIResponse<Event>> deleteEventById(@PathVariable("event-id") Long eventId) {
        Event event = this.eventServiceImplementation.deleteEventById(eventId);
        if(event == null) throw new NotFoundException("Event "+eventId+" not found.");
        return ResponseEntity.status(HttpStatus.OK).body(APIResponse.<Event>builder()
                .message("Event successfully deleted.")
                .payload(event)
                .status(HttpStatus.OK)
                .timestamp(Instant.now())
                .build());
    }
}
