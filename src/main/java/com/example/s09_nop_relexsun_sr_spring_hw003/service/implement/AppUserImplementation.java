package com.example.s09_nop_relexsun_sr_spring_hw003.service.implement;

import com.example.s09_nop_relexsun_sr_spring_hw003.repository.AppUserRepository;
import com.example.s09_nop_relexsun_sr_spring_hw003.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserImplementation implements AppUserService {
    private final AppUserRepository appUserRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.getUserByEmail(email);
    }
}
