package com.example.s09_nop_relexsun_sr_spring_hw003.repository;

import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request.EventRequest;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Event;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventRepository {
    @Results(id="eventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venue", column = "venue_id", one = @One(select = "com.example.s09_nop_relexsun_sr_spring_hw003.repository.VenueRepository.getVenueById")),
            @Result(property = "attendees", column = "event_id", many = @Many(select = "com.example.s09_nop_relexsun_sr_spring_hw003.repository.EventAttendeesRepository.getEventAttendeesById"))
    })
    @Select("""
        SELECT * FROM events
        OFFSET #{page} LIMIT #{size}
    """)
    List<Event> getAllEvent(Integer page, Integer size);

    @ResultMap("eventMapper")
    @Select("""
        SELECT * FROM events WHERE event_id = #{eventId};
    """)
    Event getEventById(Long eventId);

    @ResultMap("eventMapper")
    @Select("""
        INSERT INTO events VALUES (default, #{req.eventName}, #{req.eventDate}, #{req.venueId})
        RETURNING *;
    """)
    Event createEvent(@Param("req") EventRequest request);

    @ResultMap("eventMapper")
    @Select("""
        DELETE FROM events WHERE event_id = #{eventId}
        RETURNING *;
    """)
    Event deleteEventById(Long eventId);

    @ResultMap("eventMapper")
    @Select("""
        UPDATE events SET event_name = #{req.eventName}, event_date = #{req.eventDate}, venue_id = #{req.venueId} WHERE event_id = #{event_id}
    RETURNING *;
    """)
    Event updateEvent(@Param("event_id") Long eventId, @Param("req") EventRequest request);
}
