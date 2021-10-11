package com.inditex.inditextest.entity;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class PriceEntityIdTest {

    private static final int PRICE_LIST = 888;
    private static final int PRODUCT_ID = 999;

    @Test
    public void testGettersAndSetters(){
        PriceEntityId priceEntityId = new PriceEntityId();
        priceEntityId.setPriceList(PRICE_LIST);
        priceEntityId.setProductId(PRODUCT_ID);

        assertEquals(PRICE_LIST, priceEntityId.getPriceList());
        assertEquals(PRODUCT_ID, priceEntityId.getProductId());
    }

}
