package com.zhaokun.test;

import lombok.Data;

@Data
public class PriceMagnificationDTO {

    private String afterPrice;
    private String magnificationValue;

    public PriceMagnificationDTO() {
    }

    public PriceMagnificationDTO(String afterPrice, String magnificationValue) {
        this.afterPrice = afterPrice;
        this.magnificationValue = magnificationValue;
    }
}
