package com.springframework.spring5intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.springframework.spring5intro.config.BindingPropertiesConfig;
import com.springframework.spring5intro.config.ConstructorBindingPropertiesConfig;
import com.springframework.spring5intro.controller.ConstrutorInjectingController;
import com.springframework.spring5intro.controller.MyController;
import com.springframework.spring5intro.controller.PetServiceController;
import com.springframework.spring5intro.controller.ProfileInjectingController;
import com.springframework.spring5intro.controller.PropertyInjectingController;
import com.springframework.spring5intro.controller.SetterInjectingController;
import com.springframework.spring5intro.datasource.DatasourceServiceImpl;
import com.springframework.spring5intro.service.implementation.PrototypeBean;
import com.springframework.spring5intro.service.implementation.SingletonBean;

@ComponentScan(basePackages = { "com.springframework.springComponent", "com.springframework.spring5intro" })
@SpringBootApplication
public class SpringFrameworkApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringFrameworkApplication.class, args);

        System.out.println("------ProfileInjectingController------");

        ProfileInjectingController profileInjectingController = (ProfileInjectingController) applicationContext
                .getBean("profileInjectingController");
        System.out.println(profileInjectingController.getGreetings());

        System.out.println("------myController------");

        MyController myController = (MyController) applicationContext.getBean("myController");
        System.out.println(myController.greetings());

        System.out.println("------PropertyInjectingController------");

        PropertyInjectingController propertyInjectingController = (PropertyInjectingController) applicationContext
                .getBean("propertyInjectingController");
        System.out.println(propertyInjectingController.getGreetings());

        System.out.println("------SetterInjectingController------");

        SetterInjectingController setterInjectingController = (SetterInjectingController) applicationContext
                .getBean("setterInjectingController");
        System.out.println(setterInjectingController.getGreetings());

        System.out.println("------ConstrutorInjectingController------");

        ConstrutorInjectingController construtorInjectingController = (ConstrutorInjectingController) applicationContext
                .getBean("construtorInjectingController");
        System.out.println(construtorInjectingController.getGreetings());

        System.out.println("------PetServiceController------");

        PetServiceController petServiceController = (PetServiceController) applicationContext
                .getBean("petServiceController");
        System.out.println(petServiceController.getPetType());

        System.out.println("------SingletonBean------");

        SingletonBean singletonBean1 = applicationContext.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getSingleton());

        System.out.println("------SingletonBean 2------");

        SingletonBean singletonBean2 = applicationContext.getBean(SingletonBean.class);
        System.out.println(singletonBean2.getSingleton());

        System.out.println("------PrototypeBean------");

        PrototypeBean prototypeBean1 = applicationContext.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getPrototype());

        System.out.println("------PrototypeBean 2------");

        PrototypeBean prototypeBean2 = applicationContext.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getPrototype());

        System.out.println("------DatasourceServiceImpl------");

        DatasourceServiceImpl datasourceServiceImpl = applicationContext.getBean(DatasourceServiceImpl.class);
        System.out.println(datasourceServiceImpl.getJdbcSource());
        System.out.println(datasourceServiceImpl.getUserName());
        System.out.println(datasourceServiceImpl.getPassword());

        System.out.println("------BindingPropertiesConfig------");

        BindingPropertiesConfig bindingPropertiesConfig = applicationContext.getBean(BindingPropertiesConfig.class);
        System.out.println(bindingPropertiesConfig.getDatasource());
        System.out.println(bindingPropertiesConfig.getUsername());
        System.out.println(bindingPropertiesConfig.getPassword());

        System.out.println("------ConstructorBindingPropertiesConfig------");

        ConstructorBindingPropertiesConfig config = applicationContext
                .getBean(ConstructorBindingPropertiesConfig.class);
        System.out.println(config.getDatasource());
        System.out.println(config.getUsername());
        System.out.println(config.getPassword());

    }
}
