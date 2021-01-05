package com.example.alfabanktesttask.config;


import com.example.alfabanktesttask.client.GiphyClient;
import com.example.alfabanktesttask.client.OpenExchangeClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    @Value("${openexchange.api.url}")
    private String openExchangeURL;

    @Value("${giphy.api.url}")
    private String giphyURL;


    @Bean
    OpenExchangeClient rateInfo() {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .target(OpenExchangeClient.class, openExchangeURL);
    }

    @Bean
    GiphyClient giphyClient() {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .target(GiphyClient.class, giphyURL);
    }


}

