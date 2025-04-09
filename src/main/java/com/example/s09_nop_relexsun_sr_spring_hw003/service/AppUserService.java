package com.example.s09_nop_relexsun_sr_spring_hw003.service;

import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request.AppUserRequest;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.response.AppUserResponse;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AppUserService extends UserDetailsService {
    AppUserResponse register(AppUserRequest request);
}
