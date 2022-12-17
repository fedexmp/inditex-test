package com.test.inditex.service;

import com.test.inditex.mapper.ClothesMapper;
import com.test.inditex.model.entity.Clothes;
import com.test.inditex.openapi.model.ClothesObject;
import com.test.inditex.repository.ClothesRepository;
import com.test.inditex.service.impl.ClothesServiceImpl;
import com.test.inditex.utils.UtilsTestMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
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
        List<ClothesObject> dtoList = UtilsTestMethods.getClothesObjectList();

        Mockito.when(repository.findAll()).thenReturn(entityList);
        Mockito.when(mapper.toDto(Mockito.any())).thenReturn(dtoList);

        List<ClothesObject> result = service.getFilteredClothes();
        
        Assertions.assertNotNull(result);
        Clothes entity = entityList.get(0);
        ClothesObject resultDto = result.get(0);
        Assertions.assertEquals(entity.getName(),resultDto.getName());
        Assertions.assertEquals(entity.getSales(),resultDto.getSales());
        Assertions.assertEquals(entity.getSmall(),resultDto.getSmall());
        Assertions.assertEquals(entity.getMedium(),resultDto.getMedium());
        Assertions.assertEquals(entity.getLarge(),resultDto.getLarge());
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }
}
