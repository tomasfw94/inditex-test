package com.inditex.inditextest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

@Getter
@Setter
@AllArgsConstructor
public class PriceNotFoundException extends NoSuchElementException {

    private static final String PRICE_NOT_FOUND_ERROR_MESSAGE = "Price for product with ID: %s and brand with ID: %s for date: %s not found.";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private int productId;
    private int brandId;
    private LocalDateTime date;

    public String getErrorMessage(){
        return String.format(PRICE_NOT_FOUND_ERROR_MESSAGE, productId, brandId, date.format(formatter));
    }

}
