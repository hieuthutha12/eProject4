package com.example.aquarium.mapper;

import com.example.aquarium.bean.request.AquaticCreaturesRequest;
import com.example.aquarium.bean.response.AquaticCreaturesResponse;
import com.example.aquarium.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class AquaticCreaturesMapper {

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

    public static AquaticCreatures mapToEntityWithImages(AquaticCreaturesRequest request, Optional<User> user, Optional<Species> species) throws IOException {
        AquaticCreatures aquaticCreatures = mapToEntity(request, user, species);

        List<Img> images = request.getImages().stream()
                .filter(image -> !image.isEmpty())
                .map(image -> {
                    String originalFilename = image.getOriginalFilename();
                    String newFilename = UUID.randomUUID().toString() + "_" + originalFilename;

                    try {
                        Path path = Paths.get("uploads/" + newFilename);
                        Files.write(path, image.getBytes());
                    } catch (IOException e) {
                    }

                    Img img = new Img();
                    img.setImgName(newFilename);
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
    private static List<String> mapImgNames(List<Img> images) {
        return images.stream()
                .map(Img::getImgName)
                .collect(Collectors.toList());
    }

}
