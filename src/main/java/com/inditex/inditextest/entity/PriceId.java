package com.inditex.inditextest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import java.io.Serializable;

@Data
public class PriceId implements Serializable {

    private int priceList;

    private int productId;

    public PriceId(int priceList, int productId) {
        this.priceList = priceList;
        this.productId = productId;
    }
}
