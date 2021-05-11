package com.springframework.springComponent;

public class PetServiceFactoryImpl {

    public PetService petservice(String petService) {

        switch (petService) {
            case "dog":
                return new DogPetServiceImpl();
            case "cat":
                return new CatPetServiceImpl();
            default:
                return new DogPetServiceImpl();
        }
    }
}
