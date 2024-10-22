package com.example.aquarium.service;

import com.example.aquarium.bean.request.AreaRequest;
import com.example.aquarium.bean.response.AreaResponse;
import com.example.aquarium.exception.ResourceNotFoundException;
import com.example.aquarium.mapper.AreaMapper;
import com.example.aquarium.model.Area;
import com.example.aquarium.repository.AquaticCreaturesRepository;
import com.example.aquarium.repository.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;
    private final AquaticCreaturesRepository aquaticCreaturesRepository;

    public Area addArea(AreaRequest areaRequest) {
        Area area = AreaMapper.toEntity(areaRequest);
        return areaRepository.save(area);
    }

    public Optional<Area> findById(int id) {
        return areaRepository.findById(id);
    }

    public List<AreaResponse> getAllArea() {
        List<Area> creatures = areaRepository.findAll();
        return creatures.stream()
                .map(AreaMapper::toResponse)
                .collect(Collectors.toList());
    }

    public boolean hasAquaticCreatures(int areaId) {
        return aquaticCreaturesRepository.existsByAreaId(areaId);
    }

    public void deleteById(int id) {
        aquaticCreaturesRepository.updateAreaIdToNullByAreaId(id);
        //areaRepository.deleteById(id);
    }

    public Area update(int id, Area areaDetails) {
        Area area = areaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Area not found"));
        area.setAreaName(areaDetails.getAreaName());
        area.setEnvironmentType(areaDetails.getEnvironmentType());
        area.setDescription(areaDetails.getDescription());
        return areaRepository.save(area);
    }
}

