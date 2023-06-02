package com.example.springbootbasic.primary;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("facebook")
public class FacebookMessageService implements MessageService{
    @Override
    public void sendMessage() {
        System.out.println("Send message with facebook!");
    }
}
