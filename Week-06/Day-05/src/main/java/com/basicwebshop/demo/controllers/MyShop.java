package com.basicwebshop.demo.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyShop {

  private List<ShopItems> shopItemsList = new ArrayList<>();
  private List<ShopItems> shopItemsList2 = fillItemsList();

  @RequestMapping(value="/webshop", method = RequestMethod.GET)
  public String shop(Model model) {
    model.addAttribute("items", shopItemsList2);
    return "index";
  }

  @RequestMapping(value="/webshop/only-available", method = RequestMethod.GET)
  public String shop2(Model model) {
    List<ShopItems> shopItemsList3 = shopItemsList2.stream()
        .filter(e -> e.getQuantityOfStock() > 0)
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsList3);
    return "index";
  }

  @RequestMapping(value="/webshop/cheapest-first", method = RequestMethod.GET)
  public String shop3(Model model) {
    List<ShopItems> shopItemsList4 = shopItemsList2.stream()
        .sorted(Comparator.comparingDouble(ShopItems::getPrice))
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsList4);
    return "index";
  }

  @RequestMapping(value="/webshop/contains-nike", method = RequestMethod.GET)
  public String shop4(Model model) {
    List<ShopItems> shopItemsList5 = shopItemsList2.stream()
            .filter(e -> e.getName().toLowerCase().contains("nike") || e.getDescription()
            .toLowerCase().contains("nike"))
            .collect(Collectors.toList());
    model.addAttribute("items", shopItemsList5);
    return "index";
  }

  @RequestMapping(value="/webshop/average-price", method = RequestMethod.GET)
  public String shop5(Model model) {
     double average = shopItemsList2.stream()
         .filter(e -> e.getQuantityOfStock() > 0)
         .mapToDouble(ShopItems::getPrice)
         .average()
         .getAsDouble();
    model.addAttribute("average", average);
    return "index2";
  }

  @RequestMapping(value="/webshop/most-expensive-available", method = RequestMethod.GET)
  public String shop6(Model model) {
    String mostExpensive = shopItemsList2.stream()
        .max(Comparator.comparingDouble(ShopItems::getPrice))
        .get().getName();
    model.addAttribute("mostExpensive", mostExpensive);
    return "index3";
  }

  @RequestMapping(value="/search", method = RequestMethod.POST)
  public String shop7(@RequestParam("name") String name, Model model) {
    List<ShopItems> shopItemsList5 = shopItemsList2.stream()
            .filter(e -> e.getName().toLowerCase().contains(name.toLowerCase()) || e.getDescription()
            .toLowerCase().contains(name.toLowerCase()))
            .collect(Collectors.toList());
    model.addAttribute("items", shopItemsList5);
    return "index";
  }

  @RequestMapping(value="/more-filters", method = RequestMethod.GET)
  public String shop8(Model model) {
    model.addAttribute("items", shopItemsList2);
    return "index4";
  }

  @RequestMapping(value="/filter-by-type/clothes-and-shoes")
  public String shop9(Model model) {
    List<ShopItems> shopItemsList6 = shopItemsList2.stream()
        .filter(e-> e.getType().equals("clothes-and-shoes"))
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsList6);
    return "index4";
  }

  @RequestMapping(value="/filter-by-type/electronics")
  public String shop10(Model model) {
    List<ShopItems> shopItemsList7 = shopItemsList2.stream()
        .filter(e-> e.getType().equals("electronics"))
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsList7);
    return "index4";
  }

  @RequestMapping(value="/filter-by-type/beverages-and-snacks")
  public String shop11(Model model) {
    List<ShopItems> shopItemsList8 = shopItemsList2.stream()
        .filter(e-> e.getType().equals("beverages-and-snacks"))
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsList8);
    return "index4";
  }

  @RequestMapping(value="/euro", method = RequestMethod.GET)
  public String shop12(Model model) {
    List<ShopItems> shopItemsList9 = shopItemsList2.stream()
        .map(e -> new ShopItems(e.getName(), e.getDescription(), e.getPriceInEuro(),
            e.getQuantityOfStock(), e.getType()))
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsList9);
    return "index4";
  }

  @RequestMapping(value="/original-currency", method = RequestMethod.GET)
  public String shop13(Model model) {
    model.addAttribute("items", shopItemsList2);
    return "index4";
  }

  @RequestMapping(value="/above", method = RequestMethod.POST)
  public String shop14(@RequestParam("price") int price, Model model) {
    List<ShopItems> shopItemsList10 = shopItemsList2.stream()
        .filter(e -> e.getPrice() < price)
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsList10);
    return "index4";
  }

  @RequestMapping(value="/below", method = RequestMethod.POST)
  public String shop15(@RequestParam("price") int price, Model model) {
    List<ShopItems> shopItemsList11 = shopItemsList2.stream()
        .filter(e -> e.getPrice() > price)
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsList11);
    return "index4";
  }

  @RequestMapping(value="/exactly", method = RequestMethod.POST)
  public String shop16(@RequestParam("price") int price, Model model) {
    List<ShopItems> shopItemsList12 = shopItemsList2.stream()
        .filter(e -> e.getPrice() == price)
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsList12);
    return "index4";
  }

  public List<ShopItems> fillItemsList() {
    shopItemsList.add(new ShopItems("Running shoes", "Nike running shoes for every" +
        " day sport", 500, 5, "clothes-and-shoes"));
    shopItemsList.add(new ShopItems("Printer", "Some HP printer that will print " +
        "pages", 3000, 2, "electronics"));
    shopItemsList.add(new ShopItems("Coca cola", "0.5l standard coke", 25,
        0, "beverages-and-snacks"));
    shopItemsList.add(new ShopItems("Wokin", "Chicken with fried rice and WOKIN " +
        "sauce", 119, 100, "beverages-and-snacks"));
    shopItemsList.add(new ShopItems("T-shirt", "Blue with a corgi on a bike",
        300, 1, "clothes-and-shoes"));
    return shopItemsList;
  }
}
