package com.springframework.spring5intro.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.springframework.spring5intro.service.api.GreetingService;

@Controller
public class ConstrutorInjectingController {

    private final GreetingService greetingService;

    public ConstrutorInjectingController(@Qualifier("constructorGreetingServiceImpl") GreetingService greetingService) {
        super();
        this.greetingService = greetingService;
    }

    public String getGreetings() {
        return greetingService.sayGreeting();
    }
}
