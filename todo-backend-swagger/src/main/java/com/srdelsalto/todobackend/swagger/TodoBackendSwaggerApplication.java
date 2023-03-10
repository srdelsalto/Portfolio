package com.srdelsalto.todobackend.swagger;

import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.Registry;
import io.jkratz.mediator.spring.SpringMediator;
import io.jkratz.mediator.spring.SpringRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoBackendSwaggerApplication {
    private final ApplicationContext applicationContext;

    @Autowired
    public TodoBackendSwaggerApplication(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public Registry registry() {
        return new SpringRegistry(applicationContext);
    }

    @Bean
    public Mediator mediator(Registry registry) {
        return new SpringMediator(registry);
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoBackendSwaggerApplication.class, args);
    }

}
