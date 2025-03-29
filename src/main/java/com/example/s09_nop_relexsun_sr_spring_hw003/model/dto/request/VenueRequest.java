package com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VenueRequest {
    @NotNull
    @NotBlank(message = "Names are not allowed to be blank")
    private String venueName;
    @NotNull
    @NotBlank(message = "Locations are not allowed to be blank")
    private String location;
}
