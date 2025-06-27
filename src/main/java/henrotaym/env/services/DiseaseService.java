package henrotaym.env.services;

import henrotaym.env.dto.request.DiseaseRequest;
import henrotaym.env.dto.response.DiseaseResponse;
import henrotaym.env.entities.Disease;
import henrotaym.env.mappers.DiseaseMapper;
import henrotaym.env.mappers.OptionalMapper;
import henrotaym.env.repositories.DiseaseRepository;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiseaseService {
    private DiseaseRepository diseaseRepository;
    private DiseaseMapper diseaseMapper;
    private OptionalMapper optionalMapper;

    public DiseaseService(
            DiseaseRepository diseaseRepository,
            DiseaseMapper diseaseMapper,
            OptionalMapper optionalMapper) {
        this.diseaseRepository = diseaseRepository;
        this.diseaseMapper = diseaseMapper;
        this.optionalMapper = optionalMapper;
    }

    public void save(DiseaseRequest diseaseRequest) {
        Disease diseaseToSave = diseaseMapper.toEntity(diseaseRequest);
        diseaseRepository.save(diseaseToSave);
    }

    public Optional<DiseaseResponse> findById(BigInteger id) {
        Optional<Disease> diseaseFound = diseaseRepository.findById(id);
        return optionalMapper.mapOptional(diseaseFound, diseaseMapper::fromEntity);
    }

    public List<DiseaseResponse> findAll() {
        List<Disease> listOfDiseases = diseaseRepository.findAll();
        List<DiseaseResponse> responseList = new ArrayList<>();

        for (Disease disease : listOfDiseases) {
            DiseaseResponse response = diseaseMapper.fromEntity(disease);
            responseList.add(response);
        }

        return responseList;
    }

    public Optional<DiseaseResponse> update(BigInteger id, DiseaseRequest diseaseRequest) {
        Disease disease = diseaseMapper.toEntity(diseaseRequest);

        return diseaseRepository
                .findById(id)
                .map(
                        existingDisease -> {
                            existingDisease.setName(disease.getName());
                            existingDisease.setType(disease.getType());

                            Disease saved = diseaseRepository.save(existingDisease);
                            return diseaseMapper.fromEntity(saved);
                        });
    }

    public void deleteById(BigInteger id) {
        if (diseaseRepository.existsById(id)) {
            diseaseRepository.deleteById(id);
        }
    }
}
