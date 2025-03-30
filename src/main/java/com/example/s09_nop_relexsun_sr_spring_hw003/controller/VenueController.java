package com.example.s09_nop_relexsun_sr_spring_hw003.controller;

import com.example.s09_nop_relexsun_sr_spring_hw003.exception.NotFoundException;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.request.VenueRequest;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.dto.response.APIResponse;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Attendee;
import com.example.s09_nop_relexsun_sr_spring_hw003.model.entities.Venue;
import com.example.s09_nop_relexsun_sr_spring_hw003.service.implement.VenueServiceImplementation;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor
public class VenueController {
    private final VenueServiceImplementation venueServiceImplementation;

    @GetMapping
    public ResponseEntity<APIResponse<List<Venue>>> getAllVenue(@RequestParam(defaultValue = "1") @Positive Integer page, @RequestParam(defaultValue = "10") @Positive Integer size) {
        page = (page - 1) * size;
        List<Venue> venues = this.venueServiceImplementation.getAllVenue(page, size);
        APIResponse<List<Venue>> response = APIResponse.<List<Venue>>builder()
                .message("All venues successfully fetch.")
                .payload(venues)
                .status(HttpStatus.OK)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{venue-id}")
    public ResponseEntity<APIResponse<Venue>> getVenueById(@PathVariable("venue-id") Long id) {
        Venue venue = this.venueServiceImplementation.getVenueById(id);
        if (venue == null) throw new NotFoundException("Venue "+id+" not found");
        APIResponse<Venue> response = APIResponse.<Venue>builder()
                .message("All venues successfully fetch.")
                .payload(venue)
                .status(HttpStatus.OK)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Venue>> createVenue(@RequestBody @Valid VenueRequest request) {
        Venue venue = this.venueServiceImplementation.createVenue(request);
        APIResponse<Venue> response = APIResponse.<Venue>builder()
                .message("Venue has created successfully.")
                .payload(venue)
                .status(HttpStatus.CREATED)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{venue-id}")
    public ResponseEntity<APIResponse<Venue>> updateVenue(@PathVariable("venue-id") Long id, @RequestBody @Valid VenueRequest request) {
        Venue venue = this.venueServiceImplementation.updateVenue(id, request);
        if (venue == null) throw new NotFoundException("Venue "+id+" not found");
        APIResponse<Venue> response = APIResponse.<Venue>builder()
                .message("Venue has updated successfully.")
                .payload(venue)
                .status(HttpStatus.OK)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{venue-id}")
    public ResponseEntity<APIResponse<String>> deleteVenueById(@PathVariable("venue-id") Long id){
        Venue venue = this.venueServiceImplementation.deleteVenueById(id);
        if (venue == null) throw new NotFoundException("Venue "+id+" not found");
        APIResponse<String> response = APIResponse.<String>builder().message("Venue successfully deleted").payload(null).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
