package com.example.springbootbasic.propertysource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:myapp.properties")
public class SpringBootBasicApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootBasicApplication.class, args);

    }

}
