package com.udacity.jdnd.course1.Controller;

import com.udacity.jdnd.course1.Model.MessageForm;
import com.udacity.jdnd.course1.Service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

  private MessageService messageService;

  public HomeController(MessageService messageService) {
    this.messageService = messageService;
  }

  @GetMapping("/home")
  public String getHome(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
    model.addAttribute("greetings", messageService.getMessages());
    return "home";
  }

  @PostMapping("/home")
  public String addMessage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
    messageService.addMessage(newMessage.getText());
    model.addAttribute("greetings", messageService.getMessages());
    newMessage.setText("");
    return "home";
  }

}
