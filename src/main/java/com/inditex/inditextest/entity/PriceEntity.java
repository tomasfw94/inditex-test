package com.inditex.inditextest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@IdClass(PriceEntityId.class)
@Table(name = "PRICES")
public class PriceEntity {

    @OneToOne(targetEntity = BrandEntity.class)
    @JoinColumn(name = "BRAND_ID")
    private BrandEntity brand;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Id
    @Column(name = "PRICE_LIST")
    private int priceList;

    @Id
    @Column(name = "PRODUCT_ID")
    private int productId;

    @Column(name = "PRIORITY")
    private int priority;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "CURR")
    private String curr;

}
