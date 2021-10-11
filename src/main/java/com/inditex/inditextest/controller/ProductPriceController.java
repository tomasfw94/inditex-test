package com.inditex.inditextest.controller;

import com.inditex.inditextest.dto.ProductPriceDto;
import com.inditex.inditextest.entity.Price;
import com.inditex.inditextest.entity.PriceId;
import com.inditex.inditextest.exception.ProductNotFoundException;
import com.inditex.inditextest.repository.PriceRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
public class ProductPriceController {

    private PriceRepository priceRepository;

    @Autowired
    public ProductPriceController(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }

    @GetMapping("/product-price")
    public ResponseEntity getProductPriceInformationByDate(
            @RequestParam (name = "date") LocalDateTime date,
            @RequestParam (name = "product") int productId,
            @RequestParam (name = "brand") int brandId){

        //Placeholder functionality
        Price price = priceRepository.findById(new PriceId(1, productId)).orElseThrow(() -> new ProductNotFoundException(productId, brandId));

        ProductPriceDto ppDto = new ProductPriceDto();
        ppDto.setProductId(price.getProductId());
        ppDto.setBrandId(price.getBrand().getBrandId());
        ppDto.setStartDate(price.getStartDate());
        ppDto.setEndDate(price.getEndDate());
        ppDto.setPvp(price.getPrice());

        return new ResponseEntity(ppDto, HttpStatus.OK);
    }
}
