package com.inditex.inditextest.controller;

import com.inditex.inditextest.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PriceController {

    private IPriceService priceService;

    @Autowired
    public PriceController(IPriceService priceService){
        this.priceService = priceService;
    }

    @GetMapping("/product/{productId}/brand/{brandId}/price")
    public ResponseEntity getProductPriceInformationByBrandAndDate(
            @PathVariable int productId,
            @PathVariable int brandId,
            @RequestParam (name = "date") LocalDateTime date){

        return new ResponseEntity(priceService.getProductPriceInformationByBrandAndDate(productId, brandId, date), HttpStatus.OK);
    }

}
