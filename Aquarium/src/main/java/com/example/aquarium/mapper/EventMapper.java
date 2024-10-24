package com.example.aquarium.mapper;

import com.example.aquarium.bean.request.EventRequest;
import com.example.aquarium.bean.response.EventResponse;
import com.example.aquarium.model.Event;
import com.example.aquarium.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class EventMapper {

    @Value("${custom.date-format}")
    private String dateFormat;

//    public String formatDate(LocalDateTime date) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
//        return date.format(formatter);
//    }

    public LocalDateTime parseDate(String dateStr) throws IllegalArgumentException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        try {
            return LocalDateTime.parse(dateStr, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format: " + dateStr, e);
        }
    }
    public Event toEntity(EventRequest eventRequest, User user) throws IOException {
        Event existingEvent = new Event();
        existingEvent.setEventName(eventRequest.getEventName());
        existingEvent.setDescription(eventRequest.getDescription());

        existingEvent.setStartDate(parseDate(eventRequest.getStartDate()));
        existingEvent.setEndDate(parseDate(eventRequest.getEndDate()));
        existingEvent.setUser(user);

        if (eventRequest.getImg() != null &&!eventRequest.getImg().isEmpty()) {
            String imageName = saveImage(eventRequest.getImg());
            existingEvent.setImg(imageName);
        }

        return existingEvent;
    }

    public String saveImage(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String newFilename = UUID.randomUUID().toString() + "_" + originalFilename;

        Path path = Paths.get("uploads/" + newFilename);
        Files.write(path, file.getBytes());

        return newFilename;
    }

    public static EventResponse toResponse(Event event) {
        EventResponse response = new EventResponse();
        response.setId(event.getId());
        response.setEventName(event.getEventName());
        response.setDescription(event.getDescription());
        response.setStartDate(event.getStartDate());
        response.setEndDate(event.getEndDate());
        response.setImg(event.getImg());
        response.setNameU(event.getUser() != null ? event.getUser().getFirstName()+" "+ event.getUser().getLastName() : null);
        return response;
    }
}

