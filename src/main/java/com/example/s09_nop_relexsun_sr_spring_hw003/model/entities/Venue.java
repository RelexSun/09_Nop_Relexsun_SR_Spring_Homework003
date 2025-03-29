package com.example.s09_nop_relexsun_sr_spring_hw003.model.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venue {
    private Long venueId;
    private String venueName;
    private String location;
}
