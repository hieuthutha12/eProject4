package com.example.aquarium.controller;

import com.example.aquarium.bean.request.AreaRequest;
import com.example.aquarium.bean.response.AreaResponse;
import com.example.aquarium.bean.response.MessageResponse;
import com.example.aquarium.model.Area;
import com.example.aquarium.service.AreaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
@RequiredArgsConstructor
public class AreaController {

    private final AreaService areaService;

    @PostMapping()
    public ResponseEntity<MessageResponse> createArea(@Valid @RequestBody AreaRequest area) {
        Area savedArea = areaService.addArea(area);
        return new ResponseEntity<>(new MessageResponse("Successfully!"), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> getAreaById(@PathVariable int id) {
        return areaService.findById(id)
                .map(area -> new ResponseEntity<>(area, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<AreaResponse>> getAllAreas() {
        List<AreaResponse> areas = areaService.getAllArea();
        return new ResponseEntity<>(areas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Area> updateArea(@PathVariable int id, @Valid @RequestBody Area areaDetails) {
        Area updatedArea = areaService.update(id, areaDetails);
        return new ResponseEntity<>(updatedArea, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArea(@PathVariable int id) {
        if (areaService.hasAquaticCreatures(id)) {
            return new ResponseEntity<>("This area is being used by aquatic creatures. Do you really want to delete it? Please confirm with a query parameter.", HttpStatus.CONFLICT);
        }
        areaService.deleteById(id);
        return new ResponseEntity<>("Area deleted successfully.", HttpStatus.NO_CONTENT);
    }
}

