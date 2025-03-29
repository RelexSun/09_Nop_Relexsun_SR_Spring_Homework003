package com.example.s09_nop_relexsun_sr_spring_hw003.model.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attendee {
    private Long attendeesId;
    private String attendeesName;
    private String email;
}