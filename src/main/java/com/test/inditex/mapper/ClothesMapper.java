package com.test.inditex.mapper;

import com.test.inditex.model.entity.Clothes;
import com.test.inditex.openapi.model.ClothesObjectRequest;
import com.test.inditex.openapi.model.ClothesObjectResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClothesMapper {

    /**
     * map entity list to dto list
     *
     * @param entity {@link List<Clothes>} object list
     * @return {@link List<ClothesObjectResponse>} object list
     */
    List<ClothesObjectResponse> toDtoList(List<Clothes> entity);

    /**
     * map dto list to entity list
     *
     * @param dto {@link List<ClothesObjectResponse>} object list
     * @return {@link List<Clothes>} object list
     */
    List<Clothes> toEntityFromResponseList(List<ClothesObjectResponse> dto);

    /**
     * map dto list to entity list
     *
     * @param dto {@link List<ClothesObjectRequest>} object list
     * @return {@link List<Clothes>} object list
     */
    List<Clothes> toEntityFromRequestList(List<ClothesObjectRequest> dto);

    /**
     * map dto to entity
     *
     * @param dto {@link ClothesObjectRequest} object
     * @return {@link Clothes} object
     */
    Clothes toEntityFromRequest(ClothesObjectRequest dto);

    /**
     * map entity to dto
     *
     * @param entity {@link Clothes} object
     * @return {@link ClothesObjectRequest} object
     */
    ClothesObjectResponse toDtoResponse(Clothes entity);

}
