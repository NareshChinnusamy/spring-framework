package com.springframework.spring5intro.service.implementation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springframework.spring5intro.service.api.GreetingService;

@Profile({ "ES", "default" })
@Service("sampler")
public class ProfileEsServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "This is Spanish greeting service impl";
    }
}
