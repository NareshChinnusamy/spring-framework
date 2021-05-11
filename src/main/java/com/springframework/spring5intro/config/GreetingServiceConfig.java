package com.springframework.spring5intro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.springframework.spring5intro.service.implementation.ConstructorGreetingServiceImpl;
import com.springframework.spring5intro.service.implementation.PrimaryGreetingServiceImpl;
import com.springframework.spring5intro.service.implementation.ProfileEsServiceImpl;

@Configuration
public class GreetingServiceConfig {

    @Bean
    public ConstructorGreetingServiceImpl constructorGreetingServiceImpl() {
        return new ConstructorGreetingServiceImpl();
    }

    @Primary
    @Bean
    public PrimaryGreetingServiceImpl primaryGreetingServiceImpl() {
        return new PrimaryGreetingServiceImpl();
    }

    @Profile({ "ES", "default" })
    @Bean // ("sampler") -->used to override the method name in the qualifier
    public ProfileEsServiceImpl sampler() {
        return new ProfileEsServiceImpl();
    }
}
