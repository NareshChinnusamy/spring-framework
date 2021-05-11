package com.springframework.springComponent;

public class DogPetServiceImpl implements PetService {

    @Override
    public String setPetType() {
        return "This Pet type is Dog";
    }

}
