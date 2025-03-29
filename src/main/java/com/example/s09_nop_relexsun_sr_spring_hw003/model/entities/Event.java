package com.example.s09_nop_relexsun_sr_spring_hw003.model.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    private Long eventId;
    private String eventName;
    private LocalDateTime eventDate;
    private Venue venue;
    private List<Attendee> attendees;
}
