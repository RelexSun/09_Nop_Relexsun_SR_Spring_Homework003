package com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class AttendeesRequest {
    @NotNull
    @NotBlank(message = "Names are not allowed to be blank")
    private String attendeesName;
    @NotNull
    @NotBlank(message = "Email are not allowed to be blank")
    @Email
    private String email;
}
