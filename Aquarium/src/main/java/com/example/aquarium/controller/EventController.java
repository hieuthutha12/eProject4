package com.example.aquarium.controller;
import com.example.aquarium.bean.request.EventRequest;
import com.example.aquarium.bean.response.EventResponse;
import com.example.aquarium.bean.response.MessageResponse;
import com.example.aquarium.exception.ResourceNotFoundException;
import com.example.aquarium.model.AquaticCreatures;
import com.example.aquarium.model.Event;
import com.example.aquarium.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping
    public List<EventResponse> getAllEvents() {
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable Integer id) {
        return eventService.findById(id)
                .map(event -> ResponseEntity.ok(event))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    //@PreAuthorize("hasAuthority('EVENT_CREATE')")
    public ResponseEntity<MessageResponse> createEvent(@Valid @ModelAttribute EventRequest eventRequest) {
        try {
            eventService.createEvent(eventRequest);
            return new ResponseEntity<>(new MessageResponse("Successfully!"), HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(new MessageResponse("Error occurred while saving creature!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> updateEvent(@PathVariable Integer id, @Valid @ModelAttribute EventRequest eventRequest) {
        try {
            eventService.updateEvent(id, eventRequest);
            return ResponseEntity.ok(new MessageResponse("Event updated successfully!")); // HTTP 200 OK
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("An error occurred: " + e.getMessage()));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer id) {
        eventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
