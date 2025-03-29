package com.example.s09_nop_relexsun_sr_spring_hw003.repository;

import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request.AttendeesRequest;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Attendee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttendeesRepository {
    @Results(id="attendeesMapper", value = {
            @Result(property = "attendeesId", column = "attendees_id"),
            @Result(property = "attendeesName", column = "attendees_name"),
    })
    @Select("""
        SELECT * FROM attendees
    OFFSET #{page} LIMIT #{size};
    """)
    List<Attendee> getAllAttendees(Integer page, Integer size);

    @ResultMap("attendeesMapper")
    @Select("""
        SELECT * FROM attendees WHERE attendees_id = #{attendeesId};
    """)
    Attendee getAttendeesById(Long attendeesId);

    @ResultMap("attendeesMapper")
    @Select("""
        INSERT INTO attendees VALUES (default, #{req.attendeesName}, #{req.email})
        RETURNING *;
    """)
    Attendee createAttendee(@Param("req") AttendeesRequest req);

    @ResultMap("attendeesMapper")
    @Select("""
        UPDATE attendees SET attendees_name = #{req.attendeesName}, email = #{req.email} WHERE attendees_id = #{attendeesId}
        RETURNING *;
    """)
    Attendee updateAttendee(Long attendeesId, @Param("req") AttendeesRequest request);

    @ResultMap("attendeesMapper")
    @Select("""
        DELETE FROM attendees WHERE attendees_id = #{attendeesId}
         RETURNING *;
    """)
    Attendee deleteAttendee(Long attendeesId);
}
