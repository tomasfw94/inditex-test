package com.inditex.inditextest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {

    //TODO naming
    @GetMapping("/")
    public ResponseEntity endpoint(){
        return new ResponseEntity(HttpStatus.OK);
    }
}
