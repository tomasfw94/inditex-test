package com.inditex.inditextest.dto;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class PriceDtoTest {

    private static final int PRODUCT_ID = 10;
    private static final int BRAND_ID = 1;
    private static final int PRICE_LIST = 5;
    private static final LocalDateTime START_DATE = LocalDateTime.now().minusDays(1);
    private static final LocalDateTime END_DATE = LocalDateTime.now().plusDays(1);;
    private static final BigDecimal PVP = BigDecimal.valueOf(99.99);

    @Test
    public void priceDtoBuilder_correctParameters_buildsOk(){
        PriceDto testPriceDto = PriceDto.builder()
                .productId(PRODUCT_ID)
                .brandId(BRAND_ID)
                .priceList(PRICE_LIST)
                .startDate(START_DATE)
                .endDate(END_DATE)
                .pvp(PVP).build();

        assertEquals(PRODUCT_ID, testPriceDto.getProductId());
        assertEquals(BRAND_ID, testPriceDto.getBrandId());
        assertEquals(PRICE_LIST, testPriceDto.getPriceList());
        assertEquals(START_DATE, testPriceDto.getStartDate());
        assertEquals(END_DATE, testPriceDto.getEndDate());
        assertEquals(PVP, testPriceDto.getPvp());
    }
}
