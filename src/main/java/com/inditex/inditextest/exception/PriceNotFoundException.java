package com.inditex.inditextest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Getter
@Setter
@AllArgsConstructor
public class PriceNotFoundException extends NoSuchElementException {

    private int productId;
    private int brandId;
    private LocalDateTime date;

}
