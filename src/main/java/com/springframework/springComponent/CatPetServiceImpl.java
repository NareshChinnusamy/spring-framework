package com.springframework.springComponent;

import org.springframework.stereotype.Service;

@Service
public class CatPetServiceImpl implements PetService {

    @Override
    public String setPetType() {
        return "My Pet is Bobcat";
    }

}
