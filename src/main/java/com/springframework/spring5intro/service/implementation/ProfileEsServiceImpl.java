package com.springframework.spring5intro.service.implementation;

import com.springframework.spring5intro.service.api.GreetingService;

public class ProfileEsServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "This is Spanish greeting service impl";
    }
}
