package com.springframework.spring5intro.dao;

public class GreetingRepositoryImpl implements GreetingRepository {

    @Override
    public String getOneGreeting() {
        return "I got the first greeting overall";
    }

}
