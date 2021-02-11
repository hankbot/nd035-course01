package com.udacity.jdnd.course1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {

  @Bean
  public String message() {
    System.out.println("Creating message bean");
    return "Hello, Spring!";
  }

  @Bean
  public String uppercaseMessage(MessageService messageService) {
    System.out.println("Creating uppercaseMessage bean");
    return messageService.messageToUpper();
  }

  @Bean
  public String lowercaseMessage(MessageService messageService) {
    System.out.println("Creating lowercaseMessage bean");
    return messageService.messageToLower();
  }

}
