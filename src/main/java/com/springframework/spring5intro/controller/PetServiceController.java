package com.springframework.spring5intro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.springframework.springComponent.PetService;

@Controller
public class PetServiceController {

    @Qualifier("rotweiler")
    @Autowired
    public PetService petService;

    public String getPetType() {
        return petService.setPetType();
    }
}
