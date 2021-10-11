package com.inditex.inditextest.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceTest {

    @Test
    public void priceBuilder_correctParameters_buildsOk(){
        Brand brand = new Brand(1, "brand");
        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        LocalDateTime endDate = LocalDateTime.now().plusDays(1);;
        int priceList = 5;
        int productId = 10;
        int priority = 15;
        BigDecimal price = BigDecimal.valueOf(99.99);
        String curr = "EUR";

        Price testPrice = Price.builder()
                .brand(brand)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(priceList)
                .productId(productId)
                .priority(priority)
                .price(price)
                .curr(curr).build();

        assertEquals(brand, testPrice.getBrand());
        assertEquals(startDate, testPrice.getStartDate());
        assertEquals(endDate, testPrice.getEndDate());
        assertEquals(priceList, testPrice.getPriceList());
        assertEquals(productId, testPrice.getProductId());
        assertEquals(priority, testPrice.getPriority());
        assertEquals(price, testPrice.getPrice());
        assertEquals(curr, testPrice.getCurr());
    }

}
