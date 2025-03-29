package com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse <T> {
    private String message;
    private T payload;
    private HttpStatus status;
    private Instant timestamp;
}
