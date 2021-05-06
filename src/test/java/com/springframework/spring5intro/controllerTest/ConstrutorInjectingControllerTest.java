package com.springframework.spring5intro.controllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springframework.spring5intro.controller.ConstrutorInjectingController;
import com.springframework.spring5intro.service.implementation.ConstructorGreetingServiceImpl;

public class ConstrutorInjectingControllerTest {

    ConstrutorInjectingController controller;

    @BeforeEach
    public void setup() {
        controller = new ConstrutorInjectingController(new ConstructorGreetingServiceImpl());
    }

    @Test
    public void getGreetingTest() {
        System.out.println(controller.getGreetings());
    }
}
