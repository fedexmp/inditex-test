package com.test.inditex.controller;

import com.test.inditex.openapi.model.ClothesObjectRequest;
import com.test.inditex.openapi.model.ClothesObjectResponse;
import com.test.inditex.openapi.model.Created;
import com.test.inditex.service.ClothesService;
import com.test.inditex.utils.UtilsTestMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
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

    @Test
    public void postClothesTest() {
        List<ClothesObjectRequest> dtoList = UtilsTestMethods.getClothesObjectRequestList();


        ResponseEntity<Created> result = controller.postClothes(dtoList);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getBody(), new Created().message("Created Succesfully"));

        Mockito.verify(service, Mockito.times(1)).createClothes(Mockito.any());
    }

    @Test
    public void putClothesTest() {
        ClothesObjectRequest dtoRequest = UtilsTestMethods.getClothesObjectRequest();
        ClothesObjectResponse dtoResponse = UtilsTestMethods.getClothesObjectResponse();

        Mockito.when(service.updateClothes(Mockito.any(), Mockito.any())).thenReturn(dtoResponse);

        ResponseEntity<ClothesObjectResponse> result = controller.putClothes(1L, dtoRequest);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getBody(), dtoResponse);

        Mockito.verify(service, Mockito.times(1)).updateClothes(Mockito.any(), Mockito.any());
    }

    @Test
    public void deleteClothesTest() {

        ResponseEntity<Void> result = controller.deleteClothes(1L);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getStatusCode(), HttpStatus.OK);

        Mockito.verify(service, Mockito.times(1)).deleteClothes(Mockito.any());
    }
}
