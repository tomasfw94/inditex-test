package com.inditex.inditextest.service;

import com.inditex.inditextest.repository.PriceRepository;
import org.springframework.stereotype.Component;

@Component("productPriceService")
public class ProductPriceService implements ProductService {

    private PriceRepository priceRepository;

    public ProductPriceService(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }

}
