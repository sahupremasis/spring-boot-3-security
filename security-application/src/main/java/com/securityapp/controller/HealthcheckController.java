package com.securityapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {

    @GetMapping("/healthcheck")
    String hello() {
        return "Hello World, Spring Boot!";
    }

}

