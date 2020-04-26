package com.greenfox.programmerclub.controllers;

import com.greenfox.programmerclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  private FoxService foxService;

  @Autowired
  public MainController(FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/")
  public String main(Model model) {
    model.addAttribute("fox", foxService.getFox());
    return "index";
  }

  @GetMapping("/?name=*")
  public String mainWithName(Model model) {
    model.addAttribute("fox", foxService.getFox());
    return "index";
  }

  @GetMapping("/login")
  public String getLogin() {
    return "login";
  }

  @PostMapping("/login")
  public String postLogin(@RequestParam(value = "name", defaultValue ="") String name) {
    if (foxService.doesListOfFoxesContainFoxName(name))
    return "redirect:/?name="+ name;
    else { foxService.createAndAddToListOfFoxes(name);}
    return "redirect:/?name="+ name;
  }

  @GetMapping("/nutrition&name=*")
  public String getNutritionStore(@RequestParam(value = "name", defaultValue ="") String name,
                                  Model model) {
    foxService.loadActualFox(name);
    model.addAttribute("fox", foxService.getFox());
    return "nutrition";
  }

  @PostMapping("/nutrition&name=*")
  public String postNutritionStore(@RequestParam(value = "name", defaultValue ="") String name,
                                   @RequestParam(value = "food") String food,
                                   @RequestParam(value = "drink") String drink,
                                   Model model) {
    foxService.loadActualFox(name);
    foxService.setFoodAndDrink(food, drink);
    model.addAttribute("fox", foxService.getFox());
    return "redirect:/?name="+ name;
  }

  @GetMapping("/trickcenter&name=*")
  public String getTrickCenter(@RequestParam(value = "name", defaultValue ="") String name,
                               Model model) {
    foxService.loadActualFox(name);
    model.addAttribute("fox", foxService.getFox());
    model.addAttribute("tricks", foxService.getListOfTricks());
    return "trickcenter";
  }

  @PostMapping("/trickcenter&name=*")
  public String postTrickCenter(@RequestParam(value = "name", defaultValue ="") String name,
                                @RequestParam(value = "trick") String trick) {
    foxService.loadActualFox(name);
    if (foxService.getFox().getListOfTricks().stream().noneMatch(t -> t.getName().equals(trick)))
    foxService.addTrickWithGivenName(trick);
    return "redirect:/?name="+ name;
  }
}