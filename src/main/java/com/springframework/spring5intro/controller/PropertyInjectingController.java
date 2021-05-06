package com.springframework.spring5intro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.springframework.spring5intro.service.api.GreetingService;

@Controller
public class PropertyInjectingController {

    @Qualifier("propertyGreetingServiceImpl")
    @Autowired
    public GreetingService greetingService;

    public String getGreetings() {
        return greetingService.sayGreeting();
    }
}
