package com.springframework.spring5intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springframework.spring5intro.controller.ConstrutorInjectingController;
import com.springframework.spring5intro.controller.MyController;
import com.springframework.spring5intro.controller.ProfileInjectingController;
import com.springframework.spring5intro.controller.PropertyInjectingController;
import com.springframework.spring5intro.controller.SetterInjectingController;

@SpringBootApplication
public class SpringFrameworkApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringFrameworkApplication.class, args);

        ProfileInjectingController profileInjectingController = (ProfileInjectingController) applicationContext
                .getBean("profileInjectingController");
        System.out.println(profileInjectingController.getGreetings());

        MyController myController = (MyController) applicationContext.getBean("myController");

        String name = myController.greetings();

        System.out.println(name);

        PropertyInjectingController propertyInjectingController = (PropertyInjectingController) applicationContext
                .getBean("propertyInjectingController");

        String name1 = propertyInjectingController.getGreetings();

        System.out.println(name1);

        SetterInjectingController setterInjectingController = (SetterInjectingController) applicationContext
                .getBean("setterInjectingController");

        String name2 = setterInjectingController.getGreetings();

        System.out.println(name2);

        ConstrutorInjectingController construtorInjectingController = (ConstrutorInjectingController) applicationContext
                .getBean("construtorInjectingController");

        String name3 = construtorInjectingController.getGreetings();

        System.out.println(name3);
    }
}
