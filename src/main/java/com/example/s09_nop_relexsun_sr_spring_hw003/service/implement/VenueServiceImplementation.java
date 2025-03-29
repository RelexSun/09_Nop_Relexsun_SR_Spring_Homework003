package com.example.s09_nop_relexsun_sr_spring_hw003.service.implement;

import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request.VenueRequest;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Venue;
import com.example.s09_nop_relexsun_sr_spring_hw003.repository.VenueRepository;
import com.example.s09_nop_relexsun_sr_spring_hw003.service.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenueServiceImplementation implements VenueService {
    private final VenueRepository venueRepository;
    @Override
    public List<Venue> getAllVenue(Integer page, Integer size) {
        return this.venueRepository.getAllVenue(page, size);
    }

    @Override
    public Venue getVenueById(Long id) {
        return this.venueRepository.getVenueById(id);
    }

    @Override
    public Venue createVenue(VenueRequest request) {
        return this.venueRepository.createVenue(request);
    }

    @Override
    public Venue updateVenue(Long id, VenueRequest request) {
        return this.venueRepository.updateVenue(id, request);
    }

    @Override
    public Venue deleteVenueById(Long id) {
        return this.venueRepository.deleteVenueById(id);
    }
}
