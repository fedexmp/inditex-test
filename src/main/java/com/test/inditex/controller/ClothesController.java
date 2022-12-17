package com.test.inditex.controller;

import com.test.inditex.openapi.controller.ClothesApiDelegate;
import com.test.inditex.openapi.model.ClothesObject;
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
    public ResponseEntity<List<ClothesObject>> getClothes() {
        return new ResponseEntity<>(clothesService.getFilteredClothes(), HttpStatus.OK);
    }
}
