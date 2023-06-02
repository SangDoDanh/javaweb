package com.example.springbootbasic.primary;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class EmailMessageService implements MessageService{
    @Override
    public void sendMessage() {
        System.out.println("Send message with email!");
    }
}
