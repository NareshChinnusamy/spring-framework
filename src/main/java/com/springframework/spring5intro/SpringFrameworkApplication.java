package com.springframework.spring5intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.springframework.spring5intro.controller.ConstrutorInjectingController;
import com.springframework.spring5intro.controller.MyController;
import com.springframework.spring5intro.controller.PetServiceController;
import com.springframework.spring5intro.controller.ProfileInjectingController;
import com.springframework.spring5intro.controller.PropertyInjectingController;
import com.springframework.spring5intro.controller.SetterInjectingController;
import com.springframework.spring5intro.service.implementation.PrototypeBean;
import com.springframework.spring5intro.service.implementation.SingletonBean;

@ComponentScan(basePackages = { "com.springframework.springComponent", "com.springframework.spring5intro" })
@SpringBootApplication
public class SpringFrameworkApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringFrameworkApplication.class, args);

        ProfileInjectingController profileInjectingController = (ProfileInjectingController) applicationContext
                .getBean("profileInjectingController");
        System.out.println(profileInjectingController.getGreetings());

        MyController myController = (MyController) applicationContext.getBean("myController");
        System.out.println(myController.greetings());

        PropertyInjectingController propertyInjectingController = (PropertyInjectingController) applicationContext
                .getBean("propertyInjectingController");
        System.out.println(propertyInjectingController.getGreetings());

        SetterInjectingController setterInjectingController = (SetterInjectingController) applicationContext
                .getBean("setterInjectingController");
        System.out.println(setterInjectingController.getGreetings());

        ConstrutorInjectingController construtorInjectingController = (ConstrutorInjectingController) applicationContext
                .getBean("construtorInjectingController");
        System.out.println(construtorInjectingController.getGreetings());

        PetServiceController petServiceController = (PetServiceController) applicationContext
                .getBean("petServiceController");
        System.out.println(petServiceController.getPetType());

        SingletonBean singletonBean1 = applicationContext.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getSingleton());

        SingletonBean singletonBean2 = applicationContext.getBean(SingletonBean.class);
        System.out.println(singletonBean2.getSingleton());

        PrototypeBean prototypeBean1 = applicationContext.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getPrototype());

        PrototypeBean prototypeBean2 = applicationContext.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getPrototype());
    }
}
