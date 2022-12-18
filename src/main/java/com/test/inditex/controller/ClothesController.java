package com.test.inditex.controller;

import com.test.inditex.openapi.controller.ClothesApiDelegate;
import com.test.inditex.openapi.model.ClothesObjectRequest;
import com.test.inditex.openapi.model.ClothesObjectResponse;
import com.test.inditex.openapi.model.Created;
import com.test.inditex.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClothesController implements ClothesApiDelegate {

    @Autowired
    private ClothesService clothesService;

    @Override
    public ResponseEntity<List<ClothesObjectResponse>> getClothes() {
        return new ResponseEntity<>(clothesService.getFilteredClothes(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Created> postClothes(List<ClothesObjectRequest> clothesObjectRequest) {
        clothesService.createClothes(clothesObjectRequest);
        return new ResponseEntity<>(new Created().message("Created Succesfully"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ClothesObjectResponse> putClothes(Long id,
                                                            ClothesObjectRequest clothesObjectRequest) {
        return new ResponseEntity<>(clothesService.updateClothes(id, clothesObjectRequest), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteClothes(Long id) {
        clothesService.deleteClothes(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
