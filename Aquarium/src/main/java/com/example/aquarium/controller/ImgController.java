package com.example.aquarium.controller;

import com.example.aquarium.bean.response.MessageResponse;
import com.example.aquarium.exception.ResourceNotFoundException;
import com.example.aquarium.service.ImgService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImgController {
    private final ResourceLoader resourceLoader;
    private final ImgService imgService;

    @PostMapping("/{id}/upload-image")
    public ResponseEntity<MessageResponse> uploadImage(@PathVariable Integer id, @RequestParam("img") MultipartFile file) {
        try {
            imgService.uploadImage(id, file);
            return ResponseEntity.ok(new MessageResponse("Image uploaded successfully!"));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse(e.getMessage()));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error occurred while uploading image!"));
        }
    }

    @GetMapping("/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = resourceLoader.getResource("file:E:/Img/" + filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
