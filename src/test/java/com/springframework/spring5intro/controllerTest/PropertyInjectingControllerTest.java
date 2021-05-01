package com.springframework.spring5intro.controllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springframework.spring5intro.controller.PropertyInjectingController;
import com.springframework.spring5intro.service.implementation.GreetingServiceImpl;

public class PropertyInjectingControllerTest {

    PropertyInjectingController controller;

    @BeforeEach
    public void setup() {
        controller = new PropertyInjectingController();
        controller.greetingService = new GreetingServiceImpl();
    }

    @Test
    public void sayGreetingsTest() {
        System.out.println(controller.getGreetings());
    }
}
