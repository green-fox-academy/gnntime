package com.greenfoxacademy.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWebController {

  private AtomicLong counter = new AtomicLong();

  @RequestMapping("/web/greeting")
  public String greeting(@RequestParam(value = "name") String name, Model model) {
    model.addAttribute("name", name + "!" + " This site was loaded " +
        counter.incrementAndGet() + " times since last server start.");
    return "greeting";
  }
}
