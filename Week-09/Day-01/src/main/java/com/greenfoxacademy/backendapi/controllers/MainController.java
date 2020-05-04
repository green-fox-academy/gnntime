package com.greenfoxacademy.backendapi.controllers;

import com.greenfoxacademy.backendapi.models.Until;
import com.greenfoxacademy.backendapi.services.BackEndService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
  BackEndService backEndService;

  @Autowired
  public MainController(BackEndService backEndService) {
    this.backEndService = backEndService;
  }

  @GetMapping("/")
  public String getIndex() {
    return "index";
  }

  @ResponseBody
  @GetMapping("/doubling")
  public ResponseEntity<?> getDoubling(@RequestParam(value = "input", defaultValue = "0") int input) {
    if (input == 0) {
      return ResponseEntity.ok().body(backEndService.sendErrorMessage("Please provide an input!"));
    } else {
      return ResponseEntity.ok().body(backEndService.doubleTheNumber(input));
    }
  }

  @ResponseBody
  @GetMapping("/greeter")
  public ResponseEntity<?> getGreeter(@RequestParam(value = "name", defaultValue = "") String name,
                                      @RequestParam(value = "title", defaultValue = "") String title) {
    if (name.equals("") && title.equals("")) {
      return ResponseEntity.badRequest().body(backEndService.sendErrorMessage("Please provide a name and a title!"));
    } else if (name.equals("")) {
      return ResponseEntity.badRequest().body(backEndService.sendErrorMessage("Please provide a name!"));
    } else if (title.equals("")) {
      return ResponseEntity.badRequest().body(backEndService.sendErrorMessage("Please provide a title!"));
    } else {
      return ResponseEntity.ok().body(backEndService.sendGreeterWithNameAndTitle(name, title));
    }
  }

  @ResponseBody
  @GetMapping("/appenda/{appendable}")
  public ResponseEntity<?> getAppendA(@PathVariable("appendable") String appendable) {
    return ResponseEntity.ok().body(backEndService.appendWordWithA(appendable));
  }

  @ResponseBody
  @PostMapping(value = "/dountil/{action}")
  public ResponseEntity<?> postDoUntil(@PathVariable("action") String action,
                                       @RequestBody Until until) {
    if (action.equals("sum")) {
      return ResponseEntity.ok().body(backEndService.sum(until));
    } else if (action.equals("factor")) {
      return ResponseEntity.ok().body(backEndService.factor(until));
    } else if (until.getUntil() == 0) {
      return ResponseEntity.badRequest().body(backEndService.sendErrorMessage("Please provide a number!"));
    } else {
      return ResponseEntity.badRequest().body(backEndService.sendErrorMessage("Unsupported action"));
    }
  }
}
