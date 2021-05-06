package com.springframework.spring5intro.service.implementation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springframework.spring5intro.service.api.GreetingService;

@Profile("EN")
@Service("sampler")
public class ProfileEnServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "This is English greeting service impl";
    }

}
