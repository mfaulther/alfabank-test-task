package com.example.alfabanktesttask.service;

import com.example.alfabanktesttask.client.GiphyClient;
import com.example.alfabanktesttask.client.OpenExchangeClient;
import com.example.alfabanktesttask.domain.RateInfo;
import com.example.alfabanktesttask.exception.CodeNotFoundException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class RateService implements InitializingBean {

    private OpenExchangeClient openExchangeClient;
    private GiphyClient giphyClient;

    @Value("${openexchange.api.key}")
    private String openExchangeApiKey;
    @Value("${giphy.api.key}")
    private String giphyApiKey;
    @Value("${base.currency}")
    private String baseCurrency;

    private Map<String, String> openExchangeQueryMap;
    private Map<String, String> giphyQueryMap;

    private Map<String, String> currencies;

    public RateService(OpenExchangeClient openExchangeClient, GiphyClient giphyClient) {
        this.openExchangeClient = openExchangeClient;
        this.giphyClient = giphyClient;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        openExchangeQueryMap = new HashMap<>();
        openExchangeQueryMap.put("app_id", openExchangeApiKey);
        openExchangeQueryMap.put("base", baseCurrency);

        giphyQueryMap = new HashMap<>();
        giphyQueryMap.put("api_key", giphyApiKey);

        currencies = openExchangeClient.getCurrencies(openExchangeQueryMap);
    }

    private boolean checkCountryCode(String code) {
        return currencies.containsKey(code);
    }


    private Double getCurrRate(String code) {

        RateInfo currInfo = openExchangeClient.getLatestInfo(openExchangeQueryMap);
        return currInfo.getRates().get(code);

    }

    private Double getYesterdayRate(String code) {

        LocalDate yesterdayDate = LocalDate.now().minusDays(1);
        RateInfo yesterdayInfo = openExchangeClient
                .getHistoricalInfo(yesterdayDate, openExchangeQueryMap);

        return yesterdayInfo.getRates().get(code);
    }

    private String getRandomGifURL(String query) {

        int randInt = new Random().nextInt(50);

        giphyQueryMap.put("q", query);

        return giphyClient
                .gifRes(giphyQueryMap)
                .getData()
                .get(randInt)
                .getImages()
                .get("original")
                .getUrl();
    }


    public String foo(String code) {

        if (!checkCountryCode(code)) {
            throw new CodeNotFoundException();
        }
        Double currCountryRate = getCurrRate(code);
        Double yesterdayCountryRate = getYesterdayRate(code);
        String query = currCountryRate > yesterdayCountryRate ? "rich" : "broke";
        return getRandomGifURL(query);
    }

}
