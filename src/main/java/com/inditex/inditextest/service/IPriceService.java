package com.inditex.inditextest.service;

import com.inditex.inditextest.dto.PriceDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

public interface IPriceService {
    PriceDto getProductPriceInformationByBrandAndDate(int productId, int brandId, LocalDateTime date);
}
