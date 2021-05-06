package com.springframework.spring5intro.controllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springframework.spring5intro.controller.SetterInjectingController;
import com.springframework.spring5intro.service.implementation.ConstructorGreetingServiceImpl;

public class SetterInjectingControllerTest {

    SetterInjectingController controller;

    @BeforeEach
    public void setup() {
        controller = new SetterInjectingController();
        controller.setGreetingService(new ConstructorGreetingServiceImpl());
    }

    @Test
    public void getGreetingTest() {
        System.out.println(controller.getGreetings());
    }

}
