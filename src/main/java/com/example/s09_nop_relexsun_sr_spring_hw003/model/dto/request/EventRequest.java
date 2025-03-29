package com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class EventRequest {
    @NotNull
    @NotBlank(message = "Names are not allowed to be blank")
    private String eventName;
    @NotNull
    @NotBlank(message = "Dates are not allowed to be blank")
    private LocalDateTime eventDate;
    private Long venueId;
    private List<Long> attendeesId;
}
