package com.springframework.spring5intro.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String greetings() {

        System.out.println("This from the controller");
        return "greetings";
    }
}
