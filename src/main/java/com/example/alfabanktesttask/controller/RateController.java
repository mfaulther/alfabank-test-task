package com.example.alfabanktesttask.controller;

import com.example.alfabanktesttask.service.RateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RateController {

    private RateService service;

    public RateController(RateService service) {
        this.service = service;
    }

    @GetMapping("/app")
    public String getRates(@RequestParam("code") String countryCode) {
        String gifUrl = service.foo(countryCode);
        return String.format("redirect:%s", gifUrl);
    }

}
