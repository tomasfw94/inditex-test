package com.inditex.inditextest.controller;

import com.inditex.inditextest.exception.ProductNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionAdvice extends ResponseEntityExceptionHandler {

    private static final String PRODUCT_NOT_FOUND = "Product with ID: %s and Brand ID: %s not found.";

    @ExceptionHandler(value = {ProductNotFoundException.class})
    protected ResponseEntity<Object> handleConflict(ProductNotFoundException ex, WebRequest request) {
        String responseBody = String.format(PRODUCT_NOT_FOUND, ex.getProductId(), ex.getBrandId());
        return handleExceptionInternal(ex, responseBody, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
