package com.example.aquarium.service;

import com.example.aquarium.bean.request.AquaticCreaturesRequest;
import com.example.aquarium.bean.response.AquaticCreaturesResponse;
import com.example.aquarium.exception.ResourceNotFoundException;
import com.example.aquarium.mapper.AquaticCreaturesMapper;
import com.example.aquarium.model.AquaticCreatures;
import com.example.aquarium.model.Img;
import com.example.aquarium.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AquaticCreaturesService {


    private final AquaticCreaturesRepository aquaticCreaturesRepository;
    private final AquaticCreaturesMapper aquaticCreaturesMapper;
    private final UserRepository userRepository;
    private final SpeciesRespository speciesRespository;


    public AquaticCreatures createAquaticCreature(AquaticCreaturesRequest aquaticCreaturesRequest) throws IOException {
        AquaticCreatures aquaticCreatures = aquaticCreaturesMapper.mapToEntityWithImages(
                aquaticCreaturesRequest,
                userRepository.findById(aquaticCreaturesRequest.getUserId()),
                speciesRespository.findById(aquaticCreaturesRequest.getSpeciesId())
        );

        return aquaticCreaturesRepository.save(aquaticCreatures);
    }

    public List<AquaticCreaturesResponse> getAllAquaticCreatures() {
        List<AquaticCreatures> creatures =
                aquaticCreaturesRepository.findAll();
        return creatures.stream()
                .map(AquaticCreaturesMapper::toResponse)
                .collect(Collectors.toList());
    }


    public AquaticCreaturesResponse getAquaticCreatureById(int id) {
        AquaticCreatures creature = aquaticCreaturesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aquatic Creature not found"));
        return AquaticCreaturesMapper.toResponse(creature);
    }


    public AquaticCreatures updateAquaticCreature(Integer id, AquaticCreaturesRequest aquaticCreaturesRequest) throws IOException {
        AquaticCreatures aquaticCreatures = aquaticCreaturesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aquatic Creature not found"));

        aquaticCreatures.setName(aquaticCreaturesRequest.getName());
        aquaticCreatures.setWeight(aquaticCreaturesRequest.getWeight());
        aquaticCreatures.setLength(aquaticCreaturesRequest.getLength());

        aquaticCreatures.setEntryDate(aquaticCreaturesRequest.getEntryDate());
        aquaticCreatures.setExhibitStatus(aquaticCreaturesRequest.getExhibitStatus());
        aquaticCreatures.setUser(userRepository.findById(aquaticCreaturesRequest.getUserId()).orElse(null));
        aquaticCreatures.setSpecies(speciesRespository.findById(aquaticCreaturesRequest.getSpeciesId()).orElse(null));

        aquaticCreatures.getImages().clear();

        List<Img> images = aquaticCreaturesRequest.getImages().stream()
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

        aquaticCreatures.getImages().addAll(images);

        return aquaticCreaturesRepository.save(aquaticCreatures);
    }


    public void deleteAquaticCreature(Integer id) {
        AquaticCreatures aquaticCreatures = aquaticCreaturesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aquatic Creature not found"));
        aquaticCreatures.getImages().clear();
        aquaticCreaturesRepository.deleteById(id);
    }
}

