package com.example.s09_nop_relexsun_sr_spring_hw003.repository;

import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request.VenueRequest;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Attendee;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Venue;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VenueRepository {
    @Results(id="venueMapper", value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name")
    })
    @Select("""
        SELECT * FROM venues
        OFFSET #{page} LIMIT #{size}
    """)
    List<Venue> getAllVenue(Integer page, Integer size);

    @ResultMap("venueMapper")
    @Select("""
        SELECT * FROM venues WHERE venue_id = #{venueId}
    """)
    Venue getVenueById(Long venueId);

    @ResultMap("venueMapper")
    @Select("""
        INSERT INTO venues VALUES (default, #{req.venueName}, #{req.location})
        RETURNING *;
    """)
    Venue createVenue(@Param("req") VenueRequest request);

    @ResultMap("venueMapper")
    @Select("""
        UPDATE venues SET venue_name = #{req.venueName}, location = #{req.location} WHERE venue_id = #{venue_id}
        RETURNING *;
    """)
    Venue updateVenue(@Param("venue_id") Long venueId, @Param("req") VenueRequest request);

    @ResultMap("venueMapper")
    @Select("""
        DELETE FROM venues WHERE venue_id = #{venueId}
        RETURNING *;
    """)
    Venue deleteVenueById(Long venueId);
}
