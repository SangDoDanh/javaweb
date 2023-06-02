package com.example.springbootbasic.primary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootBasicApplication {
    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(SpringBootBasicApplication.class, args);

       MessageService messageService = context.getBean(MessageService.class);
       messageService.sendMessage();

       Mobile mobile = context.getBean(Mobile.class);
       mobile.getMessageService().sendMessage();
    }
}
