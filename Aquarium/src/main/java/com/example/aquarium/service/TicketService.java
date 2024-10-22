package com.example.aquarium.service;

import com.example.aquarium.bean.request.TicketRequest;
import com.example.aquarium.bean.response.TicketResponse;
import com.example.aquarium.exception.ResourceNotFoundException;
import com.example.aquarium.mapper.TicketMapper;
import com.example.aquarium.model.LoyaltyPoints;
import com.example.aquarium.model.Ticket;
import com.example.aquarium.model.Type;
import com.example.aquarium.repository.LoyaltyPointsRepository;
import com.example.aquarium.repository.TicketRepository;
import com.example.aquarium.repository.TypeRepository;
import com.example.aquarium.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    private final TicketMapper ticketMapper;

    public TicketResponse getTicket(Integer id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + id));
        return ticketMapper.toResponse(ticket);
    }

    public List<TicketResponse> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream()
                .map(ticketMapper::toResponse)
                .collect(Collectors.toList());
    }
}

