package com.chandler.webservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

    @GetMapping("/start")
    public String get() {
        return "Start Webservice";
    }

}
