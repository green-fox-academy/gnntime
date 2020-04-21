package com.thymeleaf.bankofsimba.controllers;

import java.util.ArrayList;
import java.util.List;
import com.thymeleaf.bankofsimba.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

  private List<BankAccount> accountList = new ArrayList<>();

  public MainController() {
    accountList.add(new BankAccount("Pumba", 500, "warthog", false, false));
    accountList.add(new BankAccount("Simba", 2000, "lion", false, false));
    accountList.add(new BankAccount("Timon", 800, "meerkat", false, true));
    accountList.add(new BankAccount("Zazu", 1000, "bird", false, false));
    accountList.add(new BankAccount("Mufasa", 1200, "lion", true, false));
  }

  @GetMapping(path="/show")
  public String show(Model model) {
    BankAccount account = new BankAccount("Simba", 2000, "lion", false, false);
    model.addAttribute("name", account.getName());
    model.addAttribute("balance", account.getBalance());
    model.addAttribute("type", account.getAnimalType());
    return "index";
  }
  @GetMapping(path="/sometext")
  public String someText(Model model) {
    String message = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
    model.addAttribute("text", message);
    return "index";
  }

  @GetMapping(path="/accounts")
  public String showAccounts(Model model) {
    model.addAttribute("list", accountList);
    return "index2";
  }
  @PostMapping(path="/raise")
  public String raiseAccounts(Model model) {
    model.addAttribute("list", accountList);
    for (BankAccount account: accountList) {
      account.raiseBalance();
    }
    return "index2";
  }
  @PostMapping("/add")
  public String addAccount(String name, int balance, String animalType, boolean isKing, boolean isBad, Model model) {
    model.addAttribute("list", accountList);
    accountList.add(new BankAccount(name, balance, animalType, isKing, isBad));
    return "index2";
  }
}
