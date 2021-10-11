package com.inditex.inditextest.controller;

import com.inditex.inditextest.dto.ProductPriceDto;
import com.inditex.inditextest.entity.PriceEntity;
import com.inditex.inditextest.entity.PriceEntityId;
import com.inditex.inditextest.exception.ProductNotFoundException;
import com.inditex.inditextest.model.ProductPrice;
import com.inditex.inditextest.repository.PriceRepository;
import com.inditex.inditextest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/product-price")
public class ProductPriceController {

    private PriceRepository priceRepository;
    private ProductService productPriceService;

    @Autowired
    public ProductPriceController(PriceRepository priceRepository, @Qualifier("productPriceService") ProductService productPriceService){
        this.priceRepository = priceRepository;
        this.productPriceService = productPriceService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity getProductPriceInformationByDate(
            @PathVariable int productId,
            @RequestParam (name = "date") LocalDateTime date,
            @RequestParam (name = "brand") int brandId){

        return new ResponseEntity("", HttpStatus.OK);
    }

    //Placeholder functionality
    @GetMapping("/test/{productId}")
    public ResponseEntity test(
            @PathVariable int productId,
            @RequestParam (name = "date") LocalDateTime date,
            @RequestParam (name = "brand") int brandId){

        PriceEntity price = priceRepository.findById(new PriceEntityId(1, productId)).orElseThrow(() -> new ProductNotFoundException(productId, brandId));

        ProductPriceDto ppDto = new ProductPriceDto();
        ppDto.setProductId(price.getProductId());
        ppDto.setBrandId(price.getBrand().getBrandId());
        ppDto.setStartDate(price.getStartDate());
        ppDto.setEndDate(price.getEndDate());
        ppDto.setPvp(price.getPrice());

        return new ResponseEntity(ppDto, HttpStatus.OK);
    }
}
