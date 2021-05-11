package com.springframework.spring5intro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.springframework.spring5intro.dao.GreetingRepository;
import com.springframework.spring5intro.dao.GreetingRepositoryImpl;
import com.springframework.spring5intro.service.implementation.ConstructorGreetingServiceImpl;
import com.springframework.spring5intro.service.implementation.FirstGreetingSericeImpl;
import com.springframework.spring5intro.service.implementation.PrimaryGreetingServiceImpl;
import com.springframework.spring5intro.service.implementation.ProfileEsServiceImpl;
import com.springframework.springComponent.PetService;
import com.springframework.springComponent.PetServiceFactoryImpl;

@ImportResource("classpath:Bean.xml")
@Configuration
public class GreetingServiceConfig {

    // @Bean
    public ConstructorGreetingServiceImpl constructorGreetingServiceImpl() {
        return new ConstructorGreetingServiceImpl();
    }

    @Primary
    @Bean
    public PrimaryGreetingServiceImpl primaryGreetingServiceImpl() {
        return new PrimaryGreetingServiceImpl();
    }

    @Profile({ "ES", "default" })
    @Bean("sampler") // -->used to override the method name in the qualifier
    public ProfileEsServiceImpl profileEsServiceImpl() {
        return new ProfileEsServiceImpl();
    }

    @Bean
    public GreetingRepository GreetingRepository() {
        return new GreetingRepositoryImpl();
    }

    @Profile("ESP")
    @Bean
    public FirstGreetingSericeImpl sampler() {
        return new FirstGreetingSericeImpl();
    }

    @Bean
    PetServiceFactoryImpl petServiceFactoryImpl() {
        return new PetServiceFactoryImpl();
    }

    @Profile({ "DOG", "default" })
    @Bean("rotweiler")
    public PetService dogPetService(PetServiceFactoryImpl petServiceFactoryImpl) {
        return petServiceFactoryImpl.petservice("dog");
    }

    @Profile("CAT")
    @Bean("rotweiler")
    public PetService catPetService(PetServiceFactoryImpl petServiceFactoryImpl) {
        return petServiceFactoryImpl.petservice("cat");
    }
}
