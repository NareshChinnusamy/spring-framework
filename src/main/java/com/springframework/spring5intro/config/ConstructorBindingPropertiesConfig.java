package com.springframework.spring5intro.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("spring")
public class ConstructorBindingPropertiesConfig {
    private String username;

    private String password;

    private String datasource;

    public ConstructorBindingPropertiesConfig(String username, String password, String datasource) {
        super();
        this.username = username;
        this.password = password;
        this.datasource = datasource;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDatasource() {
        return datasource;
    }

}
