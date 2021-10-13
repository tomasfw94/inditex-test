package com.inditex.inditextest.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
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
