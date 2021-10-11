package com.inditex.inditextest.repository;

import com.inditex.inditextest.model.Price;

import java.time.LocalDateTime;

public interface IPriceRepository {
    Price findProductPriceByBrandIdAndDateWithHighestPriority(int productId, int brandId, LocalDateTime date);
}
