package com.example.aquarium.mapper;

import com.example.aquarium.bean.request.TicketRequest;
import com.example.aquarium.bean.response.TicketResponse;
import com.example.aquarium.exception.ResourceNotFoundException;
import com.example.aquarium.model.OrderDetails;
import com.example.aquarium.model.Ticket;
import com.example.aquarium.model.Type;
import com.example.aquarium.repository.OrderDetailsRepository;
import com.example.aquarium.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketMapper {

    private final TypeRepository typeRepository;
    private final OrderDetailsRepository orderDetailsRepository;

    public Ticket toEntity(TicketRequest request) {
        Ticket ticket = new Ticket();
        Type type = typeRepository.findById(request.getTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("Type not found with id: " + request.getTypeId()));
        ticket.setPurchaseDate(request.getPurchaseDate());
        ticket.setExpirationDate(request.getExpirationDate());
        ticket.setStatus(request.getStatus());
        ticket.setType(type);

        return ticket;
    }

    public TicketResponse toResponse(Ticket ticket) {
        TicketResponse response = new TicketResponse();
        response.setId(ticket.getId());
        response.setPurchaseDate(ticket.getPurchaseDate());
        response.setExpirationDate(ticket.getExpirationDate());
        response.setStatus(ticket.getStatus());
        response.setTypeName(ticket.getType().getTypeName());

        return response;
    }
}
