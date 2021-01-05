package com.example.alfabanktesttask.client;

import com.example.alfabanktesttask.domain.GifResource;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;


public interface GiphyClient {

   @RequestLine("GET /search")
   GifResource gifRes(@QueryMap Map<String, String> queryMap);

}
