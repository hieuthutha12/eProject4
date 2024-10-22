package com.example.aquarium.mapper;

import com.example.aquarium.bean.request.AquaticCreaturesRequest;
import com.example.aquarium.bean.request.ImgRequest;
import com.example.aquarium.bean.response.AquaticCreaturesResponse;
import com.example.aquarium.model.AquaticCreatures;
import com.example.aquarium.model.Area;
import com.example.aquarium.model.Img;
import com.example.aquarium.model.User;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class AquaticCreaturesMapper {
    public static AquaticCreatures mapToEntity(AquaticCreaturesRequest request, Optional<User> user, Optional<Area> area) {
        AquaticCreatures aquaticCreatures = new AquaticCreatures();

        aquaticCreatures.setName(request.getName());
        aquaticCreatures.setSpecies(request.getSpecies());
        aquaticCreatures.setHabitat(request.getHabitat());
        aquaticCreatures.setDiet(request.getDiet());
        aquaticCreatures.setWeight(request.getWeight());
        aquaticCreatures.setLength(request.getLength());
        aquaticCreatures.setAverageLifespan(request.getAverageLifespan());
        aquaticCreatures.setSpecialCharacteristics(request.getSpecialCharacteristics());
        aquaticCreatures.setEntryDate(request.getEntryDate());
        aquaticCreatures.setExhibitStatus(request.getExhibitStatus());

        aquaticCreatures.setUser(user.orElse(null));
        aquaticCreatures.setArea(area.orElse(null));

        return aquaticCreatures;
    }

    public static AquaticCreatures mapToEntityWithImages(AquaticCreaturesRequest request, Optional<User> user, Optional<Area> area) throws IOException {
        AquaticCreatures aquaticCreatures = mapToEntity(request, user, area);

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
        response.setSpecies(entity.getSpecies());
        response.setHabitat(entity.getHabitat());
        response.setDiet(entity.getDiet());
        response.setWeight(entity.getWeight());
        response.setLength(entity.getLength());
        response.setAverageLifespan(entity.getAverageLifespan());
        response.setSpecialCharacteristics(entity.getSpecialCharacteristics());
        response.setEntryDate(entity.getEntryDate());
        response.setExhibitStatus(entity.getExhibitStatus());
        response.setArea(entity.getArea().getAreaName());
        response.setUser(entity.getUser().getEmail());
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
