package com.test.inditex.utils;

import com.test.inditex.model.entity.Clothes;
import com.test.inditex.openapi.model.ClothesObject;

import java.util.ArrayList;
import java.util.List;

public class UtilsTestMethods {

    /**
     * Get {@link List<ClothesObject>} object with correct structure
     */
    public static List<ClothesObject> getClothesObjectList(){
        List<ClothesObject> list = new ArrayList<>();
        ClothesObject clothesObject = new ClothesObject();
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
    public static List<Clothes> getClothesList(){
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
}
