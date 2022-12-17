package com.test.inditex.service.impl;

import com.test.inditex.openapi.model.ClothesObject;
import com.test.inditex.mapper.ClothesMapper;
import com.test.inditex.model.entity.Clothes;
import com.test.inditex.repository.ClothesRepository;
import com.test.inditex.service.ClothesService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothesServiceImpl implements ClothesService {

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    ClothesMapper clothesMapper;

    @Override
    public List<ClothesObject> getFilteredClothes() {
        List<Clothes> clothesObjects = clothesRepository.findAll();
        return clothesMapper.toDto(clothesObjects.stream().sorted(Comparator.comparingInt(Clothes::getPoints)
                .reversed()).collect(Collectors.toList()));
    }
}
