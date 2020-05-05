package com.greenfoxacademy.backendapi.controllers;

import com.greenfoxacademy.backendapi.models.Log;
import com.greenfoxacademy.backendapi.models.Text;
import com.greenfoxacademy.backendapi.models.Until;
import com.greenfoxacademy.backendapi.models.What;
import com.greenfoxacademy.backendapi.services.BackEndService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
  BackEndService backEndService;

  @Autowired
  public MainController(BackEndService backEndService) {
    this.backEndService = backEndService;
  }

  @GetMapping("/")
  public String getIndex() {
    Log log = new Log("/");
    backEndService.createLog(log);
    return "index";
  }

  @GetMapping("/doubling")
  public ResponseEntity<?> getDoubling(@RequestParam(value = "input", defaultValue = "0") int input,
                                       HttpServletRequest request) {
    Log log = new Log(request.getServletPath());
    if (input == 0) {
      log.setData(request.getQueryString());
      backEndService.saveLog(log);
      return ResponseEntity.ok().body(backEndService.sendErrorMessage("Please provide an input!"));
    } else {
      log.setData(request.getQueryString());
      backEndService.saveLog(log);
      return ResponseEntity.ok().body(backEndService.doubleTheNumber(input));
    }
  }

  @GetMapping("/greeter")
  public ResponseEntity<?> getGreeter(@RequestParam(value = "name", defaultValue = "") String name,
                                      @RequestParam(value = "title", defaultValue = "") String title,
                                      HttpServletRequest request) {
    Log log = new Log(request.getServletPath());
    if (name.equals("") && title.equals("")) {
      log.setData(request.getQueryString());
      backEndService.saveLog(log);
      return ResponseEntity.badRequest().body(backEndService.sendErrorMessage("Please provide a name and a title!"));
    } else if (name.equals("")) {
      log.setData(request.getQueryString());
      backEndService.saveLog(log);
      return ResponseEntity.badRequest().body(backEndService.sendErrorMessage("Please provide a name!"));
    } else if (title.equals("")) {
      log.setData(request.getQueryString());
      return ResponseEntity.badRequest().body(backEndService.sendErrorMessage("Please provide a title!"));
    } else {
      log.setData(request.getQueryString());
      backEndService.saveLog(log);
      return ResponseEntity.ok().body(backEndService.sendGreeterWithNameAndTitle(name, title));
    }
  }

  @GetMapping("/appenda/{appendable}")
  public ResponseEntity<?> getAppendA(@PathVariable("appendable") String appendable,
                                      HttpServletRequest request) {
    Log log = new Log(request.getServletPath());
    log.setData(appendable);
    backEndService.saveLog(log);
    return ResponseEntity.ok().body(backEndService.appendWordWithA(appendable));
  }

  @PostMapping("/dountil/{action}")
  public ResponseEntity<?> postDoUntil(@PathVariable("action") String action,
                                       @RequestBody Until until,
                                       HttpServletRequest request) {
    Log log = new Log(request.getServletPath());
    if (action.equals("sum")) {
      log.setData(action);
      backEndService.saveLog(log);
      return ResponseEntity.ok().body(backEndService.sum(until));
    } else if (action.equals("factor")) {
      log.setData(action);
      backEndService.saveLog(log);
      return ResponseEntity.ok().body(backEndService.factor(until));
    } else if (until.getUntil() == 0) {
      log.setData(action);
      backEndService.saveLog(log);
      return ResponseEntity.badRequest().body(backEndService.sendErrorMessage("Please provide a number!"));
    } else {
      log.setData(action);
      backEndService.saveLog(log);
      return ResponseEntity.badRequest().body(backEndService.sendErrorMessage("Unsupported action"));
    }
  }

  @PostMapping("/arrays")
  public ResponseEntity<?> postArray(@RequestBody What what) {
    if (what.getWhat().equals("sum") || what.getWhat().equals("multiply")) {
      return ResponseEntity.ok().body(backEndService.calculateSumOrMultiply(what));
    } else if (what.getWhat().equals("double")) {
      return ResponseEntity.ok().body(backEndService.calculateDouble(what));
    } else {
      return ResponseEntity.badRequest().body(backEndService.sendErrorMessage("A what or number is missing!"));
    }
  }

  @GetMapping("/log")
  public ResponseEntity<?> getLog() {
    return ResponseEntity.ok().body(backEndService.getAllLogs());
  }

  @PostMapping("/sith")
  public ResponseEntity<?> postSith(@RequestBody Text text) {
    return ResponseEntity.ok().body(backEndService.convertToSithText(text));
  }
}
