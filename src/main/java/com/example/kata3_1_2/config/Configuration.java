package com.example.kata3_1_2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
}
