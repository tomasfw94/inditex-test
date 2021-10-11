package com.inditex.inditextest.exception;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class PriceNotFoundExceptionTest {

    private static final String PRICE_NOT_FOUND_ERROR_MESSAGE = "Price for product with ID: %s and brand with ID: %s for date: %s not found.";

    @Test
    public void createException_errorMessage(){
        int productId = 999;
        int brandId = 888;
        LocalDateTime date = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = date.format(formatter);

        String expectedErrorMessage = String.format(PRICE_NOT_FOUND_ERROR_MESSAGE, productId, brandId, formattedDate);

        PriceNotFoundException ex = new PriceNotFoundException(productId, brandId, date);

        assertEquals(expectedErrorMessage, ex.getErrorMessage());
    }
}
