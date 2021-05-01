package com.springframework.spring5intro.service.implementation;

import org.springframework.stereotype.Service;

import com.springframework.spring5intro.service.api.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Welcome to get greeting method";
    }

}
