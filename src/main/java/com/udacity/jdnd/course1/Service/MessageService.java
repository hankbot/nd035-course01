package com.udacity.jdnd.course1.Service;

import com.udacity.jdnd.course1.Model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

  List<String> messages;
  List<ChatMessage> chatMessages;

  public List<String> getMessages() {
    return new ArrayList<>(messages);
  }

  public void addMessage(String message) {
    messages.add(message);
  }

  public List<ChatMessage> getChatMessages() {
    return new ArrayList<>(chatMessages);
  }

  public void addChatMessage(ChatMessage chatMessage) {
    chatMessages.add(chatMessage);
  }

  @PostConstruct
  private void postConstruct() {

    this.messages = new ArrayList<>();
    this.chatMessages = new ArrayList<>();
  }

}
