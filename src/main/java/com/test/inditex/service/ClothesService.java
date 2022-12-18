package com.test.inditex.service;

import com.test.inditex.openapi.model.ClothesObjectRequest;
import com.test.inditex.openapi.model.ClothesObjectResponse;

import java.util.List;

public interface ClothesService {

    /**
     * Get filtered clothes by sales and stock
     *
     * @return a {@link List<ClothesObjectResponse>} object
     */
    List<ClothesObjectResponse> getFilteredClothes();

    /**
     * Create multiples new clothes
     *
     * @param clothesObjectRequest {@link List<ClothesObjectRequest>} list of objects
     */
    void createClothes(List<ClothesObjectRequest> clothesObjectRequest);

    /**
     * Update clothes
     *
     * @param id                   identifier of clothes
     * @param clothesObjectRequest clothes to be updated
     */
    ClothesObjectResponse updateClothes(Long id, ClothesObjectRequest clothesObjectRequest);

    /**
     * Delete clothes
     *
     * @param id identifier of clothes
     */
    void deleteClothes(Long id);

}
