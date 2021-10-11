package com.inditex.inditextest.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrandTest {

    @Test
    public void brandConstructor_correctParameters_buildsOk(){
        int brandId = 1;
        String brandName = "brand";

        Brand testBrand = new Brand(brandId, brandName);

        assertEquals(brandId, testBrand.getBrandId());
        assertEquals(brandName, testBrand.getBrandName());
    }

}