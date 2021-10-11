package com.inditex.inditextest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class PriceEntityId implements Serializable {

    private int priceList;
    private int productId;

}
