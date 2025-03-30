package com.example.s09_nop_relexsun_sr_spring_hw003.controller;

import com.example.s09_nop_relexsun_sr_spring_hw003.exception.NotFoundException;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request.AttendeesRequest;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.response.APIResponse;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Attendee;
import com.example.s09_nop_relexsun_sr_spring_hw003.service.implement.AttendeesServiceImplementation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attendees")
public class AttendeesController {
    private final AttendeesServiceImplementation attendeesServiceImplementation;

    @GetMapping
    public ResponseEntity<APIResponse<List<Attendee>>> getAllAttendees(@RequestParam(defaultValue = "1") @Positive Integer page, @RequestParam(defaultValue = "10") @Positive Integer size) {
        page = (page - 1) * size;
        List<Attendee> attendees = this.attendeesServiceImplementation.getAllAttendees(page, size);
        APIResponse<List<Attendee>> response = APIResponse.<List<Attendee>>builder()
                .message("All attendees have been successfully fetched.")
                .payload(attendees)
                .status(HttpStatus.OK)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{attendees-id}")
    public ResponseEntity<APIResponse<Attendee>> getAttendeesById(@PathVariable("attendees-id") Long attendeesId) {
        Attendee attendee = this.attendeesServiceImplementation.getAttendeesById(attendeesId);

        if(attendee == null) throw new NotFoundException("Attendee "+attendeesId+" not found.");

        APIResponse<Attendee> response = APIResponse.<Attendee>builder()
                .message("All attendees have been successfully fetched.")
                .payload(attendee)
                .status(HttpStatus.OK)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Attendee>> createAttendee(@RequestBody @Valid AttendeesRequest req) {
        Attendee attendee = this.attendeesServiceImplementation.createAttendee(req);
        APIResponse<Attendee> response = APIResponse.<Attendee>builder()
                .message("Attendees created successfully.")
                .payload(attendee)
                .status(HttpStatus.CREATED)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{attendees-id}")
    public ResponseEntity<APIResponse<Attendee>> updateAttendee(@PathVariable("attendees-id") Long id, @RequestBody @Valid AttendeesRequest request) {
        Attendee attendee = this.attendeesServiceImplementation.updateAttendee(id, request);
        if(attendee == null) throw new NotFoundException("Attendee "+id+" not found.");
        APIResponse<Attendee> response = APIResponse.<Attendee>builder().message("Attendee successfully updated").payload(attendee).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{attendees-id}")
    public ResponseEntity<APIResponse<String>> deleteAttendee(@PathVariable("attendees-id") Long id){
        Attendee attendee = this.attendeesServiceImplementation.deleteAttendee(id);
        if(attendee == null) throw new NotFoundException("Attendee "+id+" not found.");
        APIResponse<String> response = APIResponse.<String>builder().message("Attendee successfully deleted").payload(null).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
