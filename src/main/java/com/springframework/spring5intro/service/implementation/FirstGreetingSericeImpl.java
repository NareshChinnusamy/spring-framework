package com.springframework.spring5intro.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.springframework.spring5intro.dao.GreetingRepository;
import com.springframework.spring5intro.service.api.GreetingService;

public class FirstGreetingSericeImpl implements GreetingService {

    @Autowired
    GreetingRepository greetingRepository;

    @Override
    public String sayGreeting() {
        return greetingRepository.getOneGreeting();
    }

}
