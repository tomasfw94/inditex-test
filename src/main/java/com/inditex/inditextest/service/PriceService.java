package com.inditex.inditextest.service;

import com.inditex.inditextest.repository.PriceRepository;

public class PriceService {

    private PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }


}
