package com.test.inditex.service;

import com.test.inditex.mapper.ClothesMapper;
import com.test.inditex.model.entity.Clothes;
import com.test.inditex.openapi.model.ClothesObjectRequest;
import com.test.inditex.openapi.model.ClothesObjectResponse;
import com.test.inditex.repository.ClothesRepository;
import com.test.inditex.service.impl.ClothesServiceImpl;
import com.test.inditex.utils.UtilsTestMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

public class ClothesServiceImplTest {

    @Mock
    private ClothesRepository repository;

    @Mock
    private ClothesMapper mapper;

    @Spy
    @InjectMocks
    private ClothesServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getFilteredClothesTest() {
        List<Clothes> entityList = UtilsTestMethods.getClothesList();
        List<ClothesObjectResponse> dtoList = UtilsTestMethods.getClothesObjectList();

        Mockito.when(repository.findAll()).thenReturn(entityList);
        Mockito.when(mapper.toDtoList(Mockito.any())).thenReturn(dtoList);

        List<ClothesObjectResponse> result = service.getFilteredClothes();

        Assertions.assertNotNull(result);
        Clothes entity = entityList.get(0);
        ClothesObjectResponse resultDto = result.get(0);
        Assertions.assertEquals(entity.getName(), resultDto.getName());
        Assertions.assertEquals(entity.getSales(), resultDto.getSales());
        Assertions.assertEquals(entity.getSmall(), resultDto.getSmall());
        Assertions.assertEquals(entity.getMedium(), resultDto.getMedium());
        Assertions.assertEquals(entity.getLarge(), resultDto.getLarge());
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    public void createClothesTest() {
        List<ClothesObjectRequest> dtoList = UtilsTestMethods.getClothesObjectRequestList();
        List<Clothes> entityList = UtilsTestMethods.getClothesList();

        Mockito.when(mapper.toEntityFromRequestList(Mockito.any())).thenReturn(entityList);

        service.createClothes(dtoList);

        Mockito.verify(repository, Mockito.times(1)).saveAll(Mockito.any());
    }

    @Test
    public void updateClothesTest() {
        ClothesObjectRequest dtoRequest = UtilsTestMethods.getClothesObjectRequest();
        Clothes entity = UtilsTestMethods.getClothes();
        ClothesObjectResponse dtoResponse = UtilsTestMethods.getClothesObjectResponse();

        Mockito.when(mapper.toEntityFromRequest(Mockito.any())).thenReturn(entity);
        Mockito.when(mapper.toDtoResponse(Mockito.any())).thenReturn(dtoResponse);

        ClothesObjectResponse result = service.updateClothes(1L, dtoRequest);

        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void deleteClothesTest() {
        service.deleteClothes(1L);

        Mockito.verify(repository, Mockito.times(1)).deleteById(Mockito.any());
    }
}
