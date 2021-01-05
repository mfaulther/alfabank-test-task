package com.example.alfabanktesttask.client;

import com.example.alfabanktesttask.domain.RateInfo;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.springframework.boot.autoconfigure.mail.MailProperties;

import java.time.LocalDate;
import java.util.Map;


public interface OpenExchangeClient {

    @RequestLine("GET /latest.json")
    public RateInfo getLatestInfo(@QueryMap Map<String, String> queryMap);

    @RequestLine("GET /historical/{date}.json")
    public RateInfo getHistoricalInfo(@Param("date") LocalDate date, @QueryMap Map<String, String> queryMap);

    @RequestLine("GET /currencies.json")
    public Map<String, String> getCurrencies(@QueryMap Map<String, String> queryMap);


}
