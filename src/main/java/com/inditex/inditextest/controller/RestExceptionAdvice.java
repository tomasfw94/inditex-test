package com.inditex.inditextest.controller;

import com.inditex.inditextest.exception.PriceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionAdvice extends ResponseEntityExceptionHandler {

    private static final String RUNTIME_ERROR = "An unexpected error has ocurred. Please try again later.";
    private static final String BAD_REQUEST = "At least one input entered contains an error. Please review them and try again.";

    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new RestExceptionResponseBody(RUNTIME_ERROR), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    protected ResponseEntity<Object> handleConflict(MethodArgumentTypeMismatchException ex, WebRequest request) {
        return handleExceptionInternal(ex, new RestExceptionResponseBody(BAD_REQUEST), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {PriceNotFoundException.class})
    protected ResponseEntity<Object> handleConflict(PriceNotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, new RestExceptionResponseBody(ex.getErrorMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
