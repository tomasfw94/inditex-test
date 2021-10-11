package com.inditex.inditextest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "BRANDS")
public class BrandEntity {

    @Id
    @Column(name = "BRAND_ID")
    private int brandId;

    @Column(name = "BRAND_NAME")
    private String brandName;

}
