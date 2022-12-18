package com.test.inditex.controller;

import com.test.inditex.openapi.model.ClothesObjectResponse;
import com.test.inditex.service.ClothesService;
import com.test.inditex.utils.UtilsTestMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ClothesControllerTest {

    @InjectMocks
    @Spy
    private ClothesController controller;

    @Mock
    private ClothesService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getClothesTest() {
        List<ClothesObjectResponse> dtoList = UtilsTestMethods.getClothesObjectList();

        Mockito.when(service.getFilteredClothes()).thenReturn(dtoList);

        ResponseEntity<List<ClothesObjectResponse>> result = controller.getClothes();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getBody(), dtoList);

        Mockito.verify(service, Mockito.times(1)).getFilteredClothes();
    }
}
