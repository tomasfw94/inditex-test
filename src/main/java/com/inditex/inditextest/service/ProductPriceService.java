package com.inditex.inditextest.service;

import com.inditex.inditextest.repository.PriceRepository;

public class ProductPriceService implements IProductPriceService {

    private PriceRepository priceRepository;

    public ProductPriceService(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }

}
