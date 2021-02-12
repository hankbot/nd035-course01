package com.udacity.jdnd.course1.Model;

public class ChatMessage {

  private String username;
  private String message;
  private ChatMessageType messageType;

  public ChatMessage() {
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ChatMessageType getMessageType() {
    return messageType;
  }

  public void setMessageType(ChatMessageType messageType) {
    this.messageType = messageType;
  }

}
