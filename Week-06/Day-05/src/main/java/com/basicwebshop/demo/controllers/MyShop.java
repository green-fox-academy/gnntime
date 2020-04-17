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
  private List<ShopItems> ItemsList = fillItemsList();

  @RequestMapping(value="/webshop", method = RequestMethod.GET)
  public String shop(Model model) {
    model.addAttribute("items", ItemsList);
    return "index";
  }

  @RequestMapping(value="/webshop/only-available", method = RequestMethod.GET)
  public String shopOnlyAvailable(Model model) {
    List<ShopItems> shopItemsListOnlyAvailableProducts = ItemsList.stream()
        .filter(e -> e.getQuantityOfStock() > 0)
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsListOnlyAvailableProducts);
    return "index";
  }

  @RequestMapping(value="/webshop/cheapest-first", method = RequestMethod.GET)
  public String shopCheapestFirst(Model model) {
    List<ShopItems> shopItemsListOrderedByCheapestFirst = ItemsList.stream()
        .sorted(Comparator.comparingDouble(ShopItems::getPrice))
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsListOrderedByCheapestFirst);
    return "index";
  }

  @RequestMapping(value="/webshop/contains-nike", method = RequestMethod.GET)
  public String shopContainsNike(Model model) {
    List<ShopItems> shopItemsListThatContainsNike = ItemsList.stream()
            .filter(e -> e.getName().toLowerCase().contains("nike") || e.getDescription()
            .toLowerCase().contains("nike"))
            .collect(Collectors.toList());
    model.addAttribute("items", shopItemsListThatContainsNike);
    return "index";
  }

  @RequestMapping(value="/webshop/average-price", method = RequestMethod.GET)
  public String shopAveragePrice(Model model) {
     double average = ItemsList.stream()
         .filter(e -> e.getQuantityOfStock() > 0)
         .mapToDouble(ShopItems::getPrice)
         .average()
         .getAsDouble();
    model.addAttribute("average", average);
    return "index2";
  }

  @RequestMapping(value="/webshop/most-expensive-available", method = RequestMethod.GET)
  public String shopMostExpensiveAvailable(Model model) {
    String mostExpensive = ItemsList.stream()
        .max(Comparator.comparingDouble(ShopItems::getPrice))
        .get().getName();
    model.addAttribute("mostExpensive", mostExpensive);
    return "index3";
  }

  @RequestMapping(value="/search", method = RequestMethod.POST)
  public String shopSearch(@RequestParam("name") String name, Model model) {
    List<ShopItems> shopItemsListContainsSearch = ItemsList.stream()
            .filter(e -> e.getName().toLowerCase().contains(name.toLowerCase()) || e.getDescription()
            .toLowerCase().contains(name.toLowerCase()))
            .collect(Collectors.toList());
    model.addAttribute("items", shopItemsListContainsSearch);
    return "index";
  }

  @RequestMapping(value="/more-filters", method = RequestMethod.GET)
  public String shopDefault(Model model) {
    model.addAttribute("items", ItemsList);
    return "index4";
  }

  @RequestMapping(value="/filter-by-type/clothes-and-shoes")
  public String shopClothesAndShoes(Model model) {
    List<ShopItems> clothesAndShoesItemsList = ItemsList.stream()
        .filter(e-> e.getType().equals("clothes-and-shoes"))
        .collect(Collectors.toList());
    model.addAttribute("items", clothesAndShoesItemsList);
    return "index4";
  }

  @RequestMapping(value="/filter-by-type/electronics")
  public String shopElectronics(Model model) {
    List<ShopItems> electronicsItemsList = ItemsList.stream()
        .filter(e-> e.getType().equals("electronics"))
        .collect(Collectors.toList());
    model.addAttribute("items", electronicsItemsList);
    return "index4";
}

  @RequestMapping(value="/filter-by-type/beverages-and-snacks")
  public String shopBevaragesAndSnacks(Model model) {
    List<ShopItems> beverageAndSnacksItemList = ItemsList.stream()
        .filter(e-> e.getType().equals("beverages-and-snacks"))
        .collect(Collectors.toList());
    model.addAttribute("items", beverageAndSnacksItemList);
    return "index4";
  }

  @RequestMapping(value="/euro", method = RequestMethod.GET)
  public String shopEuro(Model model) {
    List<ShopItems> shopItemsListWithPriceInEuro = ItemsList.stream()
        .map(e -> new ShopItems(e.getName(), e.getDescription(), e.getPriceInEuro(),
            e.getQuantityOfStock(), e.getType()))
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsListWithPriceInEuro);
    return "index4";
  }

  @RequestMapping(value="/original-currency", method = RequestMethod.GET)
  public String shopOriginalCurrency(Model model) {
    model.addAttribute("items", ItemsList);
    return "index4";
  }

  @RequestMapping(value="/above", method = RequestMethod.POST)
  public String shopAbove(@RequestParam("price") int price, Model model) {
    List<ShopItems> shopItemsListAbovePriceGiven = ItemsList.stream()
        .filter(e -> e.getPrice() < price)
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsListAbovePriceGiven);
    return "index4";
  }

  @RequestMapping(value="/below", method = RequestMethod.POST)
  public String shopBelow(@RequestParam("price") int price, Model model) {
    List<ShopItems> shopItemsListBelowPriceGiven = ItemsList.stream()
        .filter(e -> e.getPrice() > price)
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsListBelowPriceGiven);
    return "index4";
  }

  @RequestMapping(value="/exactly", method = RequestMethod.POST)
  public String shopExactly(@RequestParam("price") int price, Model model) {
    List<ShopItems> shopItemsListWithExactlyPriceGiven = ItemsList.stream()
        .filter(e -> e.getPrice() == price)
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsListWithExactlyPriceGiven);
    return "index4";
  }

  public List<ShopItems> fillItemsList() {
    shopItemsList.add(new ShopItems("Running shoes", "Nike running shoes for every" +
        " day sport", 500, 5, "clothes-and-shoes"));
    shopItemsList.add(new ShopItems("Printer", "Some HP printer that will print " +
        "pages", 3000, 2, "electronics"));
    shopItemsList.add(new ShopItems("Coca cola", "0.5l standard coke", 25,
        0, "beverages-and-snacks"));
    shopItemsList.add(new ShopItems("Wokin", "Chicken with fried rice and WOKIN" +
        "sauce", 119, 100, "beverages-and-snacks"));
    shopItemsList.add(new ShopItems("T-shirt", "Blue with a corgi on a bike",
        300, 1, "clothes-and-shoes"));
    return shopItemsList;
  }
}
