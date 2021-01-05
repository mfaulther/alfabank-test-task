package com.example.alfabanktesttask.domain;

import lombok.Data;

import java.awt.font.ImageGraphicAttribute;
import java.util.Map;


@Data
public class Gif {

    private String type;
    private String embed_url;
    private Map<String, Image> images;

}
