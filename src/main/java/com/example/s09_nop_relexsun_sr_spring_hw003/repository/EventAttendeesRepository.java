package com.example.s09_nop_relexsun_sr_spring_hw003.repository;

import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Attendee;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Event;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventAttendeesRepository {
    @Results(id="eaMapper", value = {
            @Result(property = "attendeesId", column = "attendees_id"),
            @Result(property = "attendeesName", column = "attendees_name")
    })
    @Select("""
        SELECT * FROM event_attendee ea INNER JOIN attendees a ON a.attendees_id = ea.attendees_id where event_id = #{event_id};
    """)
    List<Attendee> getEventAttendeesById(@Param("event_id") Long eventId);

    @ResultMap("eaMapper")
    @Select("""
        INSERT INTO event_attendee VALUES (#{event_id}, #{attendees_id})
    """)
    void createEventAttendees(@Param("event_id") Long eventId, @Param("attendees_id") Long attendeesId);

    @ResultMap("eaMapper")
    @Delete("""
        DELETE FROM event_attendee WHERE event_id = #{event_id}
    """)
   void deleteEventAttendees(@Param("event_id") Long eventId);

}
