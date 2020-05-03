package com.greenfox.foxclubusers.controllers;

import com.greenfox.foxclubusers.models.User;
import com.greenfox.foxclubusers.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  private PetService petService;

  @Autowired
  public MainController(PetService petService) {
    this.petService = petService;
  }

  @GetMapping("/")
  public String getLogin() {
    return "login";
  }

  @PostMapping("/")
  public String postLogin(@RequestParam(value = "username") String userName,
                          @RequestParam(value = "password") String password) {
    petService.fetchUserByNameAndPassword(userName, password);
    return "redirect:/main/";
  }

  @GetMapping("/register")
  public String getRegister(Model model) {
    model.addAttribute("user", new User());
    return "register";
  }

  @PostMapping("/register")
  public String postRegister(@ModelAttribute User user) {
    petService.createUser(user);
    return "redirect:/main/" + user.getId();
  }

  @GetMapping("/main/{id}")
  public String getMain(Model model, @PathVariable(value = "id") Long id) {
    model.addAttribute("user", petService.getUserById(id));
    return "main";
  }
}
