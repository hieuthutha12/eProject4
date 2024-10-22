package com.example.aquarium.mapper;

import com.example.aquarium.bean.request.AreaRequest;
import com.example.aquarium.bean.response.AreaResponse;
import com.example.aquarium.model.Area;
import com.example.aquarium.model.Status;

import java.util.ArrayList;
import java.util.List;

public class AreaMapper {

    public static AreaResponse toResponse(Area entity) {

        List<String> names = new ArrayList<>();

        entity.getAquaticCreatures().forEach(aquaticCreature -> {
            names.add(aquaticCreature.getName());
        });

        AreaResponse response = new AreaResponse();
        response.setAreaName(entity.getAreaName());
        response.setEnvironmentType(entity.getEnvironmentType());
        response.setDescription(entity.getDescription());
        response.setAquaticCreaturesName(names);

        return response;
    }
    public static Area toEntity(AreaRequest request) {
        Area area = new Area();
        area.setAreaName(request.getAreaName());
        area.setEnvironmentType(request.getEnvironmentType());
        area.setDescription(request.getDescription());
        area.setStatus(Status.ACTIVE);
        return area;
    }
}


