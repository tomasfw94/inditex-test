package com.inditex.inditextest.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@DataJpaTest
public class PriceEntityTest {

    @Autowired
    private TestEntityManager entityManager;

    private static final int BRAND_ID = 999;
    private static final String BRAND_NAME = "brand";
    private static final LocalDateTime START_DATE = LocalDateTime.now();
    private static final LocalDateTime END_DATE = LocalDateTime.now();
    private static final int PRICE_LIST = 999;
    private static final int PRODUCT_ID = 999;
    private static final int PRIORITY = 999;
    private static final BigDecimal PRICE = BigDecimal.valueOf(999.99);
    private static final String CURR = "curr";

    @Test
    public void savePriceEntity(){
        BrandEntity brand = new BrandEntity();
        brand.setBrandId(BRAND_ID);
        brand.setBrandName(BRAND_NAME);

        BrandEntity savedBrand = this.entityManager.persistAndFlush(brand);

        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setBrand(savedBrand);
        priceEntity.setStartDate(START_DATE);
        priceEntity.setEndDate(END_DATE);
        priceEntity.setPriceList(PRICE_LIST);
        priceEntity.setProductId(PRODUCT_ID);
        priceEntity.setPriority(PRIORITY);
        priceEntity.setPrice(PRICE);
        priceEntity.setCurr(CURR);

        PriceEntity savedPriceEntity = this.entityManager.persistAndFlush(priceEntity);

        assertEquals(priceEntity, savedPriceEntity);
    }
}
