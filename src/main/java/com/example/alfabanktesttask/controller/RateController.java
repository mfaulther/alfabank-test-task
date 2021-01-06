package com.example.alfabanktesttask.controller;

import com.example.alfabanktesttask.service.RateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RateController {

    private RateService service;

    public RateController(RateService service) {
        this.service = service;
    }

    @GetMapping("/app/{code}")
    public String mainHandler(@PathVariable("code") String countryCode) {
        String gifUrl = service.mainFunc(countryCode);
        return String.format("redirect:%s", gifUrl);
    }

}
