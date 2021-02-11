package com.udacity.jdnd.course1;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MessageService {

  String message;

  public MessageService(String message) {
    System.out.println("Created MessageService Service bean");
    this.message = message;
  }

  public String messageToUpper() {
    return this.message.toUpperCase();
  }

  public String messageToLower() {
    return this.message.toLowerCase();
  }

  @PostConstruct
  private void postConstruct() {
    System.out.println("MessageService post construct");
  }

}
