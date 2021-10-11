package com.inditex.inditextest.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.Assert.assertEquals;

@DataJpaTest
public class BrandEntityTest {

    private static final int BRAND_ID = 999;
    private static final String BRAND_NAME = "brand";

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void saveBrandEntity(){
        BrandEntity brand = new BrandEntity();
        brand.setBrandId(BRAND_ID);
        brand.setBrandName(BRAND_NAME);

        BrandEntity savedBrand = this.entityManager.persistAndFlush(brand);

        assertEquals(brand, savedBrand);
    }
}
