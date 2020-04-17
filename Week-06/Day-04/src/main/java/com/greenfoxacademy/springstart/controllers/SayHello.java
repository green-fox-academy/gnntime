package com.greenfoxacademy.springstart.controllers;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SayHello {
  private AtomicLong counter = new AtomicLong();
  private String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj",
      "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
      "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló",
      "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
      "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá",
      "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
      "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem",
      "Sawubona"};

  @RequestMapping("/sayhello")
  public String greeting(@RequestParam(name = "name") String name, @RequestParam(value = "font")
      int fontsize, @RequestParam(value = "color") String color, Model model) {
    String greeting = "";
    Random random = new Random();
    int randomNumber = random.nextInt(49);
    greeting = hellos[randomNumber];
    model.addAttribute("name", greeting + " " + name + "!" + " This site was loaded " +
        counter.incrementAndGet() + " times since last server start.");
    model.addAttribute("style", "color: " + color + ";font-size:" + fontsize + "px");
    return "greeting2";
  }
}
