package com.inditex.inditextest.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceDtoTest {

    @Test
    public void priceDtoBuilder_correctParameters_buildsOk(){
        int productId = 10;
        int brandId = 1;
        int priceList = 5;
        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        LocalDateTime endDate = LocalDateTime.now().plusDays(1);;
        BigDecimal pvp = BigDecimal.valueOf(99.99);

        PriceDto testPriceDto = PriceDto.builder()
                .productId(productId)
                .brandId(brandId)
                .priceList(priceList)
                .startDate(startDate)
                .endDate(endDate)
                .pvp(pvp).build();

        assertEquals(productId, testPriceDto.getProductId());
        assertEquals(brandId, testPriceDto.getBrandId());
        assertEquals(priceList, testPriceDto.getPriceList());
        assertEquals(startDate, testPriceDto.getStartDate());
        assertEquals(endDate, testPriceDto.getEndDate());
        assertEquals(pvp, testPriceDto.getPvp());
    }
}
