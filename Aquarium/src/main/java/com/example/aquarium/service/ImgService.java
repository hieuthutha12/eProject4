package com.example.aquarium.service;

import com.example.aquarium.exception.ResourceNotFoundException;
import com.example.aquarium.model.Event;
import com.example.aquarium.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImgService {

    private final EventRepository eventRepository;

    public void uploadImage(Integer id, MultipartFile file) throws IOException {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));

        String imgFilename = saveImage(file);
        existingEvent.setImg(imgFilename);
        eventRepository.save(existingEvent);
    }
    public String saveImage(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String newFilename = UUID.randomUUID().toString() + "_" + originalFilename;
        Path path = Paths.get("E:/Img/" + newFilename);
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());
        return newFilename;
    }
}
