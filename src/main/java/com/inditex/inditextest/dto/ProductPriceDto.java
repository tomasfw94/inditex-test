package com.inditex.inditextest.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductPriceDto {
    private int productId;
    private int brandId;
    private BigDecimal feeToApply;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal pvp;
}
