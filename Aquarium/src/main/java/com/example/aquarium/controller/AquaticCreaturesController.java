package com.example.aquarium.controller;

import com.example.aquarium.bean.request.AquaticCreaturesRequest;
import com.example.aquarium.bean.response.AquaticCreaturesResponse;
import com.example.aquarium.bean.response.MessageResponse;
import com.example.aquarium.model.AquaticCreatures;
import com.example.aquarium.service.AquaticCreaturesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/aquatic-creatures")
@RequiredArgsConstructor
public class AquaticCreaturesController {


    private final AquaticCreaturesService service;

    @PostMapping
    public ResponseEntity<MessageResponse> createAquaticCreature(@Valid @ModelAttribute AquaticCreaturesRequest creature) {
        try {
            AquaticCreatures createdCreature = service.createAquaticCreature(creature);
            return new ResponseEntity<>(new MessageResponse("Successfully!"), HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(new MessageResponse("Error occurred while saving creature!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All
    @GetMapping()
    public ResponseEntity<List<AquaticCreaturesResponse>> getAllAquaticCreatures() {
        List<AquaticCreaturesResponse> response = service.getAllAquaticCreatures();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/aquatic-creatures/{id}")
    public ResponseEntity<AquaticCreaturesResponse> getAquaticCreatureById(@PathVariable int id) {
        AquaticCreaturesResponse response = service.getAquaticCreatureById(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> updateAquaticCreature(@PathVariable Integer id, @ModelAttribute AquaticCreaturesRequest creature) throws IOException {
        try {
            AquaticCreatures updatedCreature = service.updateAquaticCreature(id, creature);
            return new ResponseEntity<>(new MessageResponse("Successfully!"), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(new MessageResponse("Error occurred while saving creature!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAquaticCreature(@PathVariable Integer id) {
        service.deleteAquaticCreature(id);
        return ResponseEntity.noContent().build();
    }
}

