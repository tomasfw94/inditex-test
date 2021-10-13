package com.inditex.inditextest.controller;

import com.inditex.inditextest.dto.PriceDto;
import com.inditex.inditextest.service.IPriceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
public class PriceControllerTestCases {

    @Autowired
    PriceController priceController;

    private static final int PRODUCT_ID = 35455;
    private static final int BRAND_ID = 1;

    @Test
//  Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    public void getProductPriceInformationByBrandAndDate_testCase_1(){
        PriceDto expectedPriceDto = PriceDto.builder()
                .productId(35455)
                .brandId(1)
                .priceList(1)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .pvp(BigDecimal.valueOf(35.50).setScale(2, RoundingMode.HALF_UP)).build();

        LocalDateTime testDate = LocalDateTime.of(2020, 6, 14, 10,0, 0);

        ResponseEntity responseFromController = priceController.getProductPriceInformationByBrandAndDate(PRODUCT_ID, BRAND_ID, testDate);

        PriceDto priceDtoResponse = (PriceDto) responseFromController.getBody();

        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
        assertEquals(expectedPriceDto.getProductId(), priceDtoResponse.getProductId());
        assertEquals(expectedPriceDto.getBrandId(), priceDtoResponse.getBrandId());
        assertEquals(expectedPriceDto.getPriceList(), priceDtoResponse.getPriceList());
        assertEquals(expectedPriceDto.getStartDate(), priceDtoResponse.getStartDate());
        assertEquals(expectedPriceDto.getEndDate(), priceDtoResponse.getEndDate());
        assertEquals(expectedPriceDto.getPvp(), priceDtoResponse.getPvp());
    }

    @Test
//  Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    public void getProductPriceInformationByBrandAndDate_testCase_2(){
        PriceDto expectedPriceDto = PriceDto.builder()
                .productId(35455)
                .brandId(1)
                .priceList(2)
                .startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
                .endDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0))
                .pvp(BigDecimal.valueOf(25.45).setScale(2, RoundingMode.HALF_UP)).build();

        LocalDateTime testDate = LocalDateTime.of(2020, 6, 14, 16,0, 0);

        ResponseEntity responseFromController = priceController.getProductPriceInformationByBrandAndDate(PRODUCT_ID, BRAND_ID, testDate);

        PriceDto priceDtoResponse = (PriceDto) responseFromController.getBody();

        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
        assertEquals(expectedPriceDto.getProductId(), priceDtoResponse.getProductId());
        assertEquals(expectedPriceDto.getBrandId(), priceDtoResponse.getBrandId());
        assertEquals(expectedPriceDto.getPriceList(), priceDtoResponse.getPriceList());
        assertEquals(expectedPriceDto.getStartDate(), priceDtoResponse.getStartDate());
        assertEquals(expectedPriceDto.getEndDate(), priceDtoResponse.getEndDate());
        assertEquals(expectedPriceDto.getPvp(), priceDtoResponse.getPvp());
    }

    @Test
//  Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    public void getProductPriceInformationByBrandAndDate_testCase_3(){
        PriceDto expectedPriceDto = PriceDto.builder()
                .productId(35455)
                .brandId(1)
                .priceList(1)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .pvp(BigDecimal.valueOf(35.50).setScale(2, RoundingMode.HALF_UP)).build();

        LocalDateTime testDate = LocalDateTime.of(2020, 6, 14, 21,0, 0);

        ResponseEntity responseFromController = priceController.getProductPriceInformationByBrandAndDate(PRODUCT_ID, BRAND_ID, testDate);

        PriceDto priceDtoResponse = (PriceDto) responseFromController.getBody();

        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
        assertEquals(expectedPriceDto.getProductId(), priceDtoResponse.getProductId());
        assertEquals(expectedPriceDto.getBrandId(), priceDtoResponse.getBrandId());
        assertEquals(expectedPriceDto.getPriceList(), priceDtoResponse.getPriceList());
        assertEquals(expectedPriceDto.getStartDate(), priceDtoResponse.getStartDate());
        assertEquals(expectedPriceDto.getEndDate(), priceDtoResponse.getEndDate());
        assertEquals(expectedPriceDto.getPvp(), priceDtoResponse.getPvp());
    }

    @Test
//  Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
    public void getProductPriceInformationByBrandAndDate_testCase_4(){
        PriceDto expectedPriceDto = PriceDto.builder()
                .productId(35455)
                .brandId(1)
                .priceList(3)
                .startDate(LocalDateTime.of(2020, 6, 15, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 6, 15, 11, 00, 00))
                .pvp(BigDecimal.valueOf(30.50).setScale(2, RoundingMode.HALF_UP)).build();

        LocalDateTime testDate = LocalDateTime.of(2020, 6, 15, 10,0, 0);

        ResponseEntity responseFromController = priceController.getProductPriceInformationByBrandAndDate(PRODUCT_ID, BRAND_ID, testDate);

        PriceDto priceDtoResponse = (PriceDto) responseFromController.getBody();

        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
        assertEquals(expectedPriceDto.getProductId(), priceDtoResponse.getProductId());
        assertEquals(expectedPriceDto.getBrandId(), priceDtoResponse.getBrandId());
        assertEquals(expectedPriceDto.getPriceList(), priceDtoResponse.getPriceList());
        assertEquals(expectedPriceDto.getStartDate(), priceDtoResponse.getStartDate());
        assertEquals(expectedPriceDto.getEndDate(), priceDtoResponse.getEndDate());
        assertEquals(expectedPriceDto.getPvp(), priceDtoResponse.getPvp());
    }

    @Test
//  Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
    public void getProductPriceInformationByBrandAndDate_testCase_5(){
        PriceDto expectedPriceDto = PriceDto.builder()
                .productId(35455)
                .brandId(1)
                .priceList(4)
                .startDate(LocalDateTime.of(2020, 6, 15, 16, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .pvp(BigDecimal.valueOf(38.95).setScale(2, RoundingMode.HALF_UP)).build();

        LocalDateTime testDate = LocalDateTime.of(2020, 6, 16, 21,0, 0);

        ResponseEntity responseFromController = priceController.getProductPriceInformationByBrandAndDate(PRODUCT_ID, BRAND_ID, testDate);

        PriceDto priceDtoResponse = (PriceDto) responseFromController.getBody();

        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
        assertEquals(expectedPriceDto.getProductId(), priceDtoResponse.getProductId());
        assertEquals(expectedPriceDto.getBrandId(), priceDtoResponse.getBrandId());
        assertEquals(expectedPriceDto.getPriceList(), priceDtoResponse.getPriceList());
        assertEquals(expectedPriceDto.getStartDate(), priceDtoResponse.getStartDate());
        assertEquals(expectedPriceDto.getEndDate(), priceDtoResponse.getEndDate());
        assertEquals(expectedPriceDto.getPvp(), priceDtoResponse.getPvp());
    }

}
