package com.example.alfabanktesttask.domain;

import lombok.Data;

import java.util.Map;

@Data
public class RateInfo {

    private String disclaimer;
    private String license;
    private Long timestamp;
    private String base;
    private Map<String, Double> rates;

}
