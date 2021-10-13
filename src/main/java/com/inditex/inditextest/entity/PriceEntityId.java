package com.inditex.inditextest.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
public class PriceEntityId implements Serializable {

    private int priceList;
    private int productId;

}
