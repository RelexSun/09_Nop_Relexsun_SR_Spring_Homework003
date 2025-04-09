package com.example.s09_nop_relexsun_sr_spring_hw003.service.implement;

import com.example.s09_nop_relexsun_sr_spring_hw003.mapper.AppUserMapper;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request.AppUserRequest;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.response.AppUserResponse;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.AppUser;
import com.example.s09_nop_relexsun_sr_spring_hw003.repository.AppUserRepository;
import com.example.s09_nop_relexsun_sr_spring_hw003.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserImplementation implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final AppUserMapper appUserMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.getUserByEmail(email);
    }

    @Override
    public AppUserResponse register(AppUserRequest request) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        request.setPassword(encoder.encode(request.getPassword()));
        AppUser user = appUserRepository.register(request);
        appUserRepository.createRolesByUserId(user.getUserId(), "ROLE_USER");
        user.setRoles(appUserRepository.getAllRolesByUserId(user.getUserId()));
        return appUserMapper.toResponse(user);
    }
}
