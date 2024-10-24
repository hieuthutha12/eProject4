package com.example.aquarium.mapper;

import com.example.aquarium.bean.request.SpeciesRequest;
import com.example.aquarium.bean.response.SpeciesResponse;
import com.example.aquarium.model.Species;

import java.util.ArrayList;
import java.util.List;

public class SpeciesMapper {

    public static SpeciesResponse toResponse(Species entity) {
        SpeciesResponse response = new SpeciesResponse();
        response.setName(entity.getName());
        response.setHabitat(entity.getHabitat());
        response.setDiet(entity.getDiet());
        response.setAverageLifespan(entity.getAverageLifespan());
        response.setSpecialCharacteristics(entity.getSpecialCharacteristics());

        List<String> aquaticCreaturesNames = new ArrayList<>();
        entity.getAquaticCreatures().forEach(aquaticCreature -> {
            aquaticCreaturesNames.add(aquaticCreature.getName());
        });
        response.setAquaticCreaturesName(aquaticCreaturesNames);

        return response;
    }

    public static Species toEntity(SpeciesRequest request) {
        Species species = new Species();
        species.setName(request.getName());
        species.setHabitat(request.getHabitat());
        species.setDiet(request.getDiet());
        species.setAverageLifespan(request.getAverageLifespan());
        species.setSpecialCharacteristics(request.getSpecialCharacteristics());
        return species;
    }
}
