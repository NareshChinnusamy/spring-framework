package com.springframework.spring5intro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springframework.spring5intro.service.api.GreetingService;

@Controller
public class MyController {

    @Autowired
    GreetingService greetingService;

    public String greetings() {
        return greetingService.sayGreeting();
    }
}
