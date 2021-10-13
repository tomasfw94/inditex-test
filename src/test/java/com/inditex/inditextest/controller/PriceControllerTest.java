package com.inditex.inditextest.controller;

import com.inditex.inditextest.dto.PriceDto;
import com.inditex.inditextest.service.IPriceService;
import jdk.jfr.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceControllerTest {

    @InjectMocks
    PriceController priceController;

    @Mock
    IPriceService priceService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private static final int BRAND_ID = 999;
    private static final int PRODUCT_ID = 888;
    private static final int PRICE_LIST = 777;
    private static final LocalDateTime START_DATE = LocalDateTime.now().minusDays(1);
    private static final LocalDateTime END_DATE = LocalDateTime.now().plusDays(1);;
    private static final BigDecimal PVP = BigDecimal.valueOf(99.99);

    private static final LocalDateTime TEST_DATE = LocalDateTime.now();

    @Test
    public void getProductPriceInformationByBrandAndDate(){
        PriceDto priceDtoFromService = PriceDto.builder()
                .productId(PRODUCT_ID)
                .brandId(BRAND_ID)
                .priceList(PRICE_LIST)
                .startDate(START_DATE)
                .endDate(END_DATE)
                .pvp(PVP).build();

        doReturn(priceDtoFromService).when(priceService).getProductPriceInformationByBrandAndDate(PRODUCT_ID, BRAND_ID, TEST_DATE);

        ResponseEntity responseFromController = priceController.getProductPriceInformationByBrandAndDate(PRODUCT_ID, BRAND_ID, TEST_DATE);

        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
        assertEquals(priceDtoFromService, responseFromController.getBody());
    }

}
