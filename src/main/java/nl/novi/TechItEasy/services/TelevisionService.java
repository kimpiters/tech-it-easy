package nl.novi.TechItEasy.services;

import nl.novi.TechItEasy.dtos.TelevisionDto;
import nl.novi.TechItEasy.dtos.TelevisionInputDto;
import nl.novi.TechItEasy.dtos.TelevisionSalesDto;
import nl.novi.TechItEasy.exceptions.RecordNotFoundException;
import nl.novi.TechItEasy.mappers.TelevisionMappers;
import nl.novi.TechItEasy.models.Television;
import nl.novi.TechItEasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<TelevisionDto> getAllTelevisions() {
        List<Television> televisions = televisionRepository.findAll();
        List<TelevisionDto> televisionDtos = new ArrayList<>();
        for (Television tv : televisions) {
            televisionDtos.add(TelevisionMappers.toTelevisionDto(tv));
        }
        return televisionDtos;
    }

    public List<TelevisionSalesDto> getAllTelevisionsForSales() {
        List<Television> televisions = televisionRepository.findAll();
        List<TelevisionSalesDto> televisionSalesDtos = new ArrayList<>();
        for (Television tv : televisions) {
            televisionSalesDtos.add(TelevisionMappers.toTelevisionSalesDto(tv));
        }
        return televisionSalesDtos;
    }

    public TelevisionDto getTelevisionById(Long id) {
        Television tv = televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Television not found"));
        return TelevisionMappers.toTelevisionDto(tv);
    }

    public Long addTelevision(TelevisionInputDto tdto) {
        return televisionRepository.save(TelevisionMappers.toTelevision(tdto)).getId();
    }

    public void updateTelevision(long id, TelevisionInputDto tdto) {
        tdto.id = id;
        televisionRepository.save(TelevisionMappers.toTelevision(tdto));
    }

    public void deleteTelevision(Long id) {
        televisionRepository.deleteById(id);
    }


}
