package com.example.s09_nop_relexsun_sr_spring_hw003.service;

import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request.VenueRequest;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Attendee;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Venue;

import java.util.List;

public interface VenueService {
    List<Venue> getAllVenue(Integer page, Integer size);

    Venue getVenueById(Long id);

    Venue createVenue(VenueRequest request);

    Venue updateVenue(Long id, VenueRequest request);

    Venue deleteVenueById(Long id);
}
