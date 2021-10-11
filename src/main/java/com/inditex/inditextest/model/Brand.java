package com.inditex.inditextest.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Brand {

    @NonNull private int brandId;
    @NonNull private String brandName;

}
