package com.heaven.propertymanagement.service.impl;

import com.heaven.propertymanagement.convertor.PropertyConvertor;
import com.heaven.propertymanagement.dto.PropertyDTO;
import com.heaven.propertymanagement.entity.PropertyEntity;
import com.heaven.propertymanagement.repository.PropertyRepository;
import com.heaven.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConvertor convertor;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity pe = convertor.convertDTOtoEntity(propertyDTO);
        pe = propertyRepository.save(pe);
        PropertyDTO dto = convertor.convertEntityToDTO(pe);
        return dto;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {

        List<PropertyEntity> listEntities=(List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> listDtos = new ArrayList<>();
        for(var entity:listEntities){
            listDtos.add(convertor.convertEntityToDTO(entity));
        }
        return listDtos;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long id) {
        Optional<PropertyEntity> opEntity = propertyRepository.findById(id);
        if(opEntity.isPresent()){
            PropertyEntity pe = opEntity.get();
            pe.setAddress(propertyDTO.getAddress());
            pe.setPrice(propertyDTO.getPrice());
            pe.setDescription(propertyDTO.getDescription());
            pe.setTitle(propertyDTO.getTitle());
            propertyRepository.save(pe);
            return convertor.convertEntityToDTO(pe);
        }
        return null;
    }

    @Override
    public PropertyDTO updateDescription(PropertyDTO propertyDTO, Long id) {
        Optional<PropertyEntity> opEntity = propertyRepository.findById(id);
        if(opEntity.isPresent()){
            PropertyEntity pe = opEntity.get();
            pe.setDescription(propertyDTO.getDescription());
            propertyRepository.save(pe);
            return convertor.convertEntityToDTO(pe);
        }
        return null;
    }

    @Override
    public PropertyDTO updatePrice(PropertyDTO propertyDTO, Long id) {
        Optional<PropertyEntity> opEntity = propertyRepository.findById(id);
        if(opEntity.isPresent()){
            PropertyEntity pe = opEntity.get();
            pe.setPrice(propertyDTO.getPrice());
            propertyRepository.save(pe);
            return convertor.convertEntityToDTO(pe);
        }
        return null;
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
