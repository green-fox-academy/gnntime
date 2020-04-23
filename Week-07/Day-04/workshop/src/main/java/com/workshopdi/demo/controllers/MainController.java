package com.workshopdi.demo.controllers;

import com.workshopdi.demo.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// ## Caesar encoder/decoder
// - Caesar coding is just shifting every character in the text with a specific number of amount in
// the alphabet, coded `example` with `1` is `fybnqmf`._
// - Have two endpoints (one for encoding and one for decoding) with a `text` and `number` query param
// - Have a link at the main page for both
// - For encoding use the `number` value, for decoding use the `-number` value when calling the caesar() method.
//     - As a rule of usage: you cannot give negative value for the 'number' query param


@Controller
public class MainController {
  private UtilityService utilityService;

  @Autowired
  public MainController(UtilityService utilityService) {
    this.utilityService = utilityService;
  }

  @GetMapping("/useful")
  public String mainPage() {
    return "index";
  }

  @GetMapping("/useful/colored")
  public String randomColoredPage(Model model) {
    model.addAttribute("style", utilityService.randomColor());
    return "index";
  }

  @GetMapping("/useful/email")
  public String emailValidation(@RequestParam(defaultValue="", value="email") String email,
                                Model model) {
    model.addAttribute("email", email);
    model.addAttribute("colorOfEmail", utilityService.validateEmail(email)
        ? "green" : "red");
    model.addAttribute("validation", utilityService.validateEmail(email)
        ? "is valid" : "is not valid");
    return "index";
  }

  @GetMapping("/useful/encode")
  public String encode(@RequestParam(defaultValue ="", value ="text") String word,
                       @RequestParam(defaultValue = "0", value = "number") int number,
                       Model model) {
    model.addAttribute("encode", utilityService.caesar(word, number));
    return "index";
  }

  @GetMapping("/useful/decode")
  public String decode(@RequestParam(defaultValue ="", value ="text") String word,
                       @RequestParam(defaultValue = "0", value = "number") int number,
                       Model model) {
    model.addAttribute("decode", utilityService.caesar(word, number * -1));
    return "index";
  }
}
