package com.springframework.spring5intro.service.implementation;

import org.springframework.stereotype.Service;

import com.springframework.spring5intro.service.api.GreetingService;

@Service
public class ConstructorGreetingServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Welcome to Constructor get greeting method";
    }

}
