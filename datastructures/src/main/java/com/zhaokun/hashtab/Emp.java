package com.zhaokun.hashtab;


import lombok.Data;

@Data
public class Emp {


    private Integer no;
    private String name;
    private Emp next;

    public Emp(Integer no, String name) {
        super();
        this.no = no;
        this.name = name;
    }
}
