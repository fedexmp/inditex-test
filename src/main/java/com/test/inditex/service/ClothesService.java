package com.test.inditex.service;

import com.test.inditex.openapi.model.ClothesObject;

import java.util.List;

public interface ClothesService {

    /**
     * Get filtered clothes by sales and stock
     *
     * @return a {@link List<ClothesObject>} object
     */
    List<ClothesObject> getFilteredClothes();
}
