package henrotaym.env.services;

import henrotaym.env.dto.request.PlantRequest;
import henrotaym.env.dto.response.PlantResponse;
import henrotaym.env.entities.Plant;
import henrotaym.env.mappers.OptionalMapper;
import henrotaym.env.mappers.PlantMapper;
import henrotaym.env.repositories.PlantRepository;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class PlantService {

    private final PlantRepository plantRepository;
    private final PlantMapper plantMapper;
    private final OptionalMapper optionalMapper;

    public PlantService(
            PlantRepository plantRepository,
            PlantMapper plantMapper,
            OptionalMapper optionalMapper) {
        this.plantRepository = plantRepository;
        this.plantMapper = plantMapper;
        this.optionalMapper = optionalMapper;
    }

    // Créer une plante
    public Plant add(PlantRequest plant) {
        Plant plantToSave = plantMapper.toEntity(plant);
        return plantRepository.save(plantToSave);
    }

    // Obtenir toutes les plantes
    public List<Plant> findAll() {
        return plantRepository.findAll();
    }

    // Obtenir une plante par ID
    public Optional<PlantResponse> findById(BigInteger id) {
        Optional<Plant> plantFound = plantRepository.findById(id);
        return optionalMapper.mapOptional(plantFound, plantMapper::fromEntity);
    }

    // Mettre à jour une plante
    public Optional<PlantResponse> update(BigInteger id, PlantRequest updatedPlant) {
        Plant plant = plantMapper.toEntity(updatedPlant);

        return plantRepository
                .findById(id)
                .map(
                        existingPlant -> {
                            existingPlant.setName(plant.getName());
                            existingPlant.setSpecies(plant.getSpecies());
                            existingPlant.setBuyingDate(plant.getBuyingDate());
                            existingPlant.setStatus(plant.getStatus());
                            Plant saved = plantRepository.save(existingPlant);
                            return plantMapper.fromEntity(saved);
                        });
    }

    // Supprimer une plante
    public boolean delete(BigInteger id) {
        if (plantRepository.existsById(id)) {
            plantRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
