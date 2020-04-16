package com.greenfoxacademy.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloUserRESTApp {
  private AtomicLong counter = new AtomicLong();

  @RequestMapping(value = "/greeting", method = RequestMethod.GET)
  public Greeting greeting(@RequestParam(value = "name") String getName) {
    return new Greeting(counter.incrementAndGet(), getName);
  }
}