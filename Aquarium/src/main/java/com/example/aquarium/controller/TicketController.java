package com.example.aquarium.controller;

import com.example.aquarium.bean.request.TicketRequest;
import com.example.aquarium.bean.response.TicketResponse;
import com.example.aquarium.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

//    @PostMapping
//    public ResponseEntity<TicketResponse> createTicket(@Valid @RequestBody TicketRequest request) {
//        TicketResponse response = ticketService.createTicket(request);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponse> getTicket(@PathVariable Integer id) {
        TicketResponse response = ticketService.getTicket(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TicketResponse>> getAllTickets() {
        List<TicketResponse> responses = ticketService.getAllTickets();
        return ResponseEntity.ok(responses);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<TicketResponse> updateTicket(@PathVariable Integer id, @Valid @RequestBody TicketRequest request) {
//        TicketResponse response = ticketService.updateTicket(id, request);
//        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTicket(@PathVariable Integer id) {
//        ticketService.deleteTicket(id);
//        return ResponseEntity.noContent().build();
//    }
}

