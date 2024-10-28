package com.example.aquarium.mapper;

import com.example.aquarium.bean.request.AquaticCreaturesRequest;
import com.example.aquarium.bean.response.AquaticCreaturesResponse;
import com.example.aquarium.model.*;
import com.example.aquarium.service.ImgService;
import org.springframework.stereotype.Component;

import java.io.IOException;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

@Component
public class AquaticCreaturesMapper {

    private ImgService imgService;

    public AquaticCreaturesMapper(ImgService imgService) {
        this.imgService = imgService;
    }

    public static AquaticCreatures mapToEntity(AquaticCreaturesRequest request, Optional<User> user, Optional<Species> species) {
        AquaticCreatures aquaticCreatures = new AquaticCreatures();

        aquaticCreatures.setName(request.getName());
        aquaticCreatures.setSpecies(species.orElse(null));
        aquaticCreatures.setWeight(request.getWeight());
        aquaticCreatures.setLength(request.getLength());
        aquaticCreatures.setEntryDate(LocalDateTime.now());
        aquaticCreatures.setExhibitStatus(request.getExhibitStatus());

        aquaticCreatures.setUser(user.orElse(null));

        return aquaticCreatures;
    }

    public AquaticCreatures mapToEntityWithImages(AquaticCreaturesRequest request, Optional<User> user, Optional<Species> species) throws IOException {
        AquaticCreatures aquaticCreatures = mapToEntity(request, user, species);

        List<Img> images = request.getImages().stream()
                .filter(image -> !image.isEmpty())
                .map(image -> {
                    String imageName = null;
                    try {
                        imageName = imgService.saveImage(image);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Img img = new Img();
                    img.setImgName(imageName);
                    img.setAquaticCreatures(aquaticCreatures);
                    return img;
                })
                .collect(Collectors.toList());

        aquaticCreatures.setImages(images);

        return aquaticCreatures;
    }


    public static AquaticCreaturesResponse toResponse(AquaticCreatures entity) {
        AquaticCreaturesResponse response = new AquaticCreaturesResponse();

        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setSpecies(entity.getSpecies().getName());
        response.setWeight(entity.getWeight());
        response.setLength(entity.getLength());
        response.setEntryDate(entity.getEntryDate());
        response.setExhibitStatus(entity.getExhibitStatus());
        List<String> imgNames = entity.getImages().stream()
                .map(Img::getImgName)
                .collect(Collectors.toList());
        response.setImgName(imgNames);
        return response;
    }


}
