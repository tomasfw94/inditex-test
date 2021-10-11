package com.inditex.inditextest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.NoSuchElementException;

@Getter
@Setter
@AllArgsConstructor
public class ProductNotFoundException extends NoSuchElementException {

    private int productId;
    private int brandId;

}
