package com.test.inditex.utils;

import com.test.inditex.model.entity.Clothes;
import com.test.inditex.openapi.model.ClothesObjectRequest;
import com.test.inditex.openapi.model.ClothesObjectResponse;

import java.util.ArrayList;
import java.util.List;

public class UtilsTestMethods {

    /**
     * Get {@link List<ClothesObjectResponse>} object with correct structure
     */
    public static List<ClothesObjectResponse> getClothesObjectList() {
        List<ClothesObjectResponse> list = new ArrayList<>();
        ClothesObjectResponse clothesObject = new ClothesObjectResponse();
        clothesObject.setId(1);
        clothesObject.setName("Test T-Shirt");
        clothesObject.setSales(50);
        clothesObject.setSmall(5);
        clothesObject.setMedium(1);
        clothesObject.setLarge(1);
        list.add(clothesObject);
        return list;
    }

    /**
     * Get {@link List<Clothes>} object with correct structure
     */
    public static List<Clothes> getClothesList() {
        List<Clothes> list = new ArrayList<>();
        Clothes clothes = new Clothes();
        clothes.setId(1L);
        clothes.setName("Test T-Shirt");
        clothes.setSales(50);
        clothes.setSmall(5);
        clothes.setMedium(1);
        clothes.setLarge(1);
        list.add(clothes);
        return list;
    }

    /**
     * Get {@link List<ClothesObjectRequest>} object with correct structure
     */
    public static List<ClothesObjectRequest> getClothesObjectRequestList() {
        List<ClothesObjectRequest> list = new ArrayList<>();
        ClothesObjectRequest clothesObject = new ClothesObjectRequest();
        clothesObject.setName("Test T-Shirt");
        clothesObject.setSales(50);
        clothesObject.setSmall(5);
        clothesObject.setMedium(1);
        clothesObject.setLarge(1);
        list.add(clothesObject);
        return list;
    }

    /**
     * Get {@link ClothesObjectRequest} object with correct structure
     */
    public static ClothesObjectRequest getClothesObjectRequest() {
        ClothesObjectRequest clothesObjectRequest = new ClothesObjectRequest();
        clothesObjectRequest.setName("Test T-Shirt");
        clothesObjectRequest.setSales(50);
        clothesObjectRequest.setSmall(5);
        clothesObjectRequest.setMedium(1);
        clothesObjectRequest.setLarge(1);
        return clothesObjectRequest;
    }

    /**
     * Get {@link ClothesObjectResponse} object with correct structure
     */
    public static ClothesObjectResponse getClothesObjectResponse() {
        ClothesObjectResponse clothesObjectResponse = new ClothesObjectResponse();
        clothesObjectResponse.setId(1);
        clothesObjectResponse.setName("Test T-Shirt");
        clothesObjectResponse.setSales(50);
        clothesObjectResponse.setSmall(5);
        clothesObjectResponse.setMedium(1);
        clothesObjectResponse.setLarge(1);
        return clothesObjectResponse;
    }

    /**
     * Get {@link Clothes} object with correct structure
     */
    public static Clothes getClothes() {
        Clothes clothes = new Clothes();
        clothes.setId(1L);
        clothes.setName("Test T-Shirt");
        clothes.setSales(50);
        clothes.setSmall(5);
        clothes.setMedium(1);
        clothes.setLarge(1);
        return clothes;
    }
}
