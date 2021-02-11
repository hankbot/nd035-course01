package com.udacity.jdnd.course1.Controller;

import com.udacity.jdnd.course1.MessageForm;
import com.udacity.jdnd.course1.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimalController {

  MessageService messageService;

  public AnimalController(MessageService messageService) {
    this.messageService = messageService;
  }

  @GetMapping("/animal")
  public String getAnimalMessages(@ModelAttribute("newMessage") MessageForm messageForm, Model model) {
    model.addAttribute("greetings", messageService.getMessages());
    return "animal";
  }

  @PostMapping("/animal")
  public String addAnimalMessage(@ModelAttribute("newMessage") MessageForm messageForm, Model model) {
    messageService.addMessage(new String[]{messageForm.getAnimalName(), messageForm.getAdjective()});
    model.addAttribute("greetings", messageService.getMessages());
    messageForm.setAnimalName("");
    messageForm.setAdjective("");
    return "animal";
  }

}
