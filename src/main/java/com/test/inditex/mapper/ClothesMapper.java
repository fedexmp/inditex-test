package com.test.inditex.mapper;

import com.test.inditex.openapi.model.ClothesObject;
import com.test.inditex.model.entity.Clothes;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClothesMapper {

    /**
     * map entity to dto
     * @param entity {@link List<Clothes>} object list
     * @return {@link List<ClothesObject>} object list
     */
    List<ClothesObject> toDto (List<Clothes> entity);

    /**
     * map entity to dto
     * @param entity {@link List<ClothesObject>} object list
     * @return {@link List<Clothes>} object list
     */
    List<Clothes> toEntity (List<ClothesObject> entity);
}
