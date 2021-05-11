package com.springframework.spring5intro.service.implementation;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("creating singleton bean");
    }

    public String getSingleton() {
        return "This is from singleton";
    }
}
