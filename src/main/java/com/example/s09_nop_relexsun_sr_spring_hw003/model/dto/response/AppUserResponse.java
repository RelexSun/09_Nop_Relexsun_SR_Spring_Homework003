package com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserResponse {
    private Integer id;
    private String username;
    private String email;
    private List<String> roles;
}
