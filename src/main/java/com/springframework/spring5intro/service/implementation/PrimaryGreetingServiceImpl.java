package com.springframework.spring5intro.service.implementation;

import com.springframework.spring5intro.service.api.GreetingService;

public class PrimaryGreetingServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Welcome to Primary greeting method";
    }
}
