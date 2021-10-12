package com.inditex.inditextest.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class PriceTest {

    private static final Brand BRAND = new Brand(1, "brand");
    private static final LocalDateTime START_DATE = LocalDateTime.now().minusDays(1);
    private static final LocalDateTime END_DATE = LocalDateTime.now().plusDays(1);;
    private static final int PRICE_LIST = 5;
    private static final int PRODUCT_ID = 10;
    private static final int PRIORITY = 15;
    private static final BigDecimal PRICE = BigDecimal.valueOf(99.99);
    private static final String CURR = "EUR";

    @Test
    public void priceBuilder_correctParameters_buildsOk(){
        Price testPrice = Price.builder()
                .brand(BRAND)
                .startDate(START_DATE)
                .endDate(END_DATE)
                .priceList(PRICE_LIST)
                .productId(PRODUCT_ID)
                .priority(PRIORITY)
                .price(PRICE)
                .curr(CURR).build();

        assertEquals(BRAND, testPrice.getBrand());
        assertEquals(START_DATE, testPrice.getStartDate());
        assertEquals(END_DATE, testPrice.getEndDate());
        assertEquals(PRICE_LIST, testPrice.getPriceList());
        assertEquals(PRODUCT_ID, testPrice.getProductId());
        assertEquals(PRIORITY, testPrice.getPriority());
        assertEquals(PRICE, testPrice.getPrice());
        assertEquals(CURR, testPrice.getCurr());
    }

}
