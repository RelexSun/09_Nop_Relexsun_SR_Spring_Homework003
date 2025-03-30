package com.example.s09_nop_relexsun_sr_spring_hw003.repository;

import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.AppUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppUserRepository {
    @Results(id = "appUserMapper", value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "fullName", column = "full_name"),
            @Result(property = "roles", column = "user_id", many = @Many(select = "getAllRolesByUserId"))
    })
    @Select("""
        SELECT * FROM app_users WHERE email = #{email};
    """)
    AppUser getUserByEmail(String email);

    @Select("""
        SELECT name FROM app_roles ar INNER JOIN user_role ur ON
        ar.role_id = ur.role_id WHERE user_id = #{userId};
    """)
    List<String> getAllRolesByUserId(Long userId);

}
