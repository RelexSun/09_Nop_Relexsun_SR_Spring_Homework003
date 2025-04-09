package com.example.s09_nop_relexsun_sr_spring_hw003.mapper;

import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.response.AppUserResponse;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
    //UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    AppUserResponse toResponse(AppUser user);
}
