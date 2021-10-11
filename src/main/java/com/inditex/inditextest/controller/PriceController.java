package com.inditex.inditextest.controller;

import com.inditex.inditextest.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PriceController {

    private IPriceService productPriceService;

    @Autowired
    public PriceController(@Qualifier("priceService") IPriceService productPriceService){
        this.productPriceService = productPriceService;
    }

    @GetMapping("/product/{productId}/brand/{brandId}/price")
    public ResponseEntity getProductPriceInformationByBrandAndDate(
            @PathVariable int productId,
            @PathVariable int brandId,
            @RequestParam (name = "date") LocalDateTime date){

        productPriceService.getProductPriceInformationByBrandAndDate(productId, brandId, date);

        return new ResponseEntity("", HttpStatus.OK);
    }

}
