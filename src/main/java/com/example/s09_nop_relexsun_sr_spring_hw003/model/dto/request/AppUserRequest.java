package com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserRequest {
    private String username;
    private String email;
    private String password;
    private List<String> roles;
}
