package com.springframework.spring5intro.service.implementation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springframework.spring5intro.service.api.GreetingService;

@Primary
@Service
public class PrimaryGreetingServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Welcome to Primary greeting method";
    }
}
