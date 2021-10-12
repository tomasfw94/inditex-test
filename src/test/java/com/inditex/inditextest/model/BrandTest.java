package com.inditex.inditextest.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BrandTest {

    private static final int BRAND_ID = 1;
    private static final String BRAND_NAME = "brand";

    @Test
    public void brandConstructor_correctParameters_buildsOk(){
        Brand testBrand = new Brand(BRAND_ID, BRAND_NAME);

        assertEquals(BRAND_ID, testBrand.getBrandId());
        assertEquals(BRAND_NAME, testBrand.getBrandName());
    }

}
