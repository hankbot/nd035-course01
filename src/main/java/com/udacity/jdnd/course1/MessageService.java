package com.udacity.jdnd.course1;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

  List<String> messages;

  public List<String> getMessages() {
    return new ArrayList<>(messages);
  }

  public void addMessage(String message) {
    messages.add(message);
  }

  @PostConstruct
  private void postConstruct() {
    this.messages = new ArrayList<>();
  }

}
