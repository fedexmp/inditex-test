package com.test.inditex.service.impl;

import com.test.inditex.mapper.ClothesMapper;
import com.test.inditex.model.entity.Clothes;
import com.test.inditex.openapi.model.ClothesObjectRequest;
import com.test.inditex.openapi.model.ClothesObjectResponse;
import com.test.inditex.repository.ClothesRepository;
import com.test.inditex.service.ClothesService;
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
    public List<ClothesObjectResponse> getFilteredClothes() {
        List<Clothes> clothesObjects = clothesRepository.findAll();
        return clothesMapper.toDtoList(clothesObjects.stream().sorted(Comparator.comparingInt(Clothes::getPoints)
                .reversed()).collect(Collectors.toList()));
    }

    @Override
    public void createClothes(List<ClothesObjectRequest> clothesObjectRequest) {
        clothesRepository.saveAll(clothesMapper.toEntityFromRequestList(clothesObjectRequest));
    }

    @Override
    public ClothesObjectResponse updateClothes(Long id, ClothesObjectRequest clothesObjectRequest) {
        Clothes clothes = clothesMapper.toEntityFromRequest(clothesObjectRequest);
        clothes.setId(id);
        return clothesMapper.toDtoResponse(clothesRepository.save(clothes));
    }

    @Override
    public void deleteClothes(Long id) {
        clothesRepository.deleteById(id);
    }
}
