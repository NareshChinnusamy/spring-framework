package com.springframework.spring5intro.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.springframework.spring5intro.service.api.GreetingService;

@Controller
public class ProfileInjectingController {

    private final GreetingService greetingService;

    public ProfileInjectingController(@Qualifier("sampler") GreetingService greetingService) {
        super();
        this.greetingService = greetingService;
    }

    public String getGreetings() {
        return greetingService.sayGreeting();
    }
}
