package com.udacity.jdnd.course1.Controller;

import com.udacity.jdnd.course1.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

@Controller
public class ChatController {

  private MessageService messageService;

  public ChatController(MessageService messageService) {
    this.messageService = messageService;
  }

  @GetMapping("/chat")
  public String displayChatMessages(@ModelAttribute("chatForm") ChatForm chatForm, Model model) {
    // retrieve the list of chat messages from the service
    // Add the chat messages to the model in a form that can be used by th
    model.addAttribute("chatMessages", messageService.getChatMessages());
    return "chat";
  }

  @PostMapping("/chat")
  public String postChatMessage(@ModelAttribute("chatForm") ChatForm chatForm, Model model) {
    // Get the message from the chat form
    ChatMessage newMessage = new ChatMessage();
    newMessage.setMessage(chatForm.getMessage());
    newMessage.setUsername(chatForm.getUsername());

    // Transform to enum
    System.out.println(chatForm.getMessageType());
    newMessage.setMessageType(ChatMessageType.fromString(chatForm.getMessageType()));

    // Add the message using service
    messageService.addChatMessage(newMessage);

    // Clear the form values
    chatForm.setMessage("");
    chatForm.setUsername("");
    chatForm.setMessageType("");

    // Set the messages on the model for display
    model.addAttribute("chatMessages", messageService.getChatMessages());

    return "chat";
  }

  @PostConstruct
  private void postConstruct() {

  }

}
