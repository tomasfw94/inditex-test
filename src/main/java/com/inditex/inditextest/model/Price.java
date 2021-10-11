package com.inditex.inditextest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Price {

    private Brand brand;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private int priceList;

    private int productId;

    private int priority;

    private BigDecimal price;

    private String curr;

}
