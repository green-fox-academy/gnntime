package com.basicwebshop.demo.controllers;

import com.basicwebshop.demo.ShopItems;
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

  @RequestMapping(value="/webshop/average-stock", method = RequestMethod.GET)
  public String shopAveragePrice(Model model) {
     double average = ItemsList.stream()
         .filter(e -> e.getQuantityOfStock() > 0)
         .mapToDouble(ShopItems::getQuantityOfStock)
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
  public String shopMoreFilters(Model model) {
    model.addAttribute("items", ItemsList);
    return "index4";
  }

  @RequestMapping(value="/filter-by-type", method = RequestMethod.GET)
  public String shopClothesAndShoes(@RequestParam(value = "type") String type, Model model) {
    List<ShopItems> clothesAndShoesItemsList = ItemsList.stream()
        .filter(e-> e.getType().equals(type))
        .collect(Collectors.toList());
    model.addAttribute("items", clothesAndShoesItemsList);
    return "index4";
  }

  @RequestMapping(value="/euro", method = RequestMethod.GET)
  public String shopEuro(Model model) {
    List<ShopItems> shopItemsListWithPriceInEuro = ItemsList.stream()
        .map(e -> new ShopItems(e.getName(), e.getDescription(), e.getPriceInEuro(),
        e.getQuantityOfStock(), e.getType(), e.setAndGetCurrencyInEuro()))
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsListWithPriceInEuro);
    return "index4";
  }

  @RequestMapping(value="/original-currency", method = RequestMethod.GET)
  public String shopOriginalCurrency(Model model) {
    List<ShopItems> shopItemsListWithOriginalCurrency = ItemsList.stream()
        .map(e -> new ShopItems(e.getName(), e.getDescription(), e.getPrice(),
            e.getQuantityOfStock(), e.getType(), e.setAndGetCurrencyInOriginal()))
        .collect(Collectors.toList());
    model.addAttribute("items", shopItemsListWithOriginalCurrency);
    return "index4";
  }

  @RequestMapping(value="/search-by-price", method = RequestMethod.POST)
  public String shopPriceSearch(@RequestParam(defaultValue = "0") int price,
                                @RequestParam(value="searchType") String searchType, Model model) {
    List<ShopItems> shopItemsListPriceSearch = new ArrayList<>();
    if (searchType.equals("above")) {
      shopItemsListPriceSearch = ItemsList.stream()
          .filter(e -> e.getPrice() > price)
          .collect(Collectors.toList());
    } else if (searchType.equals("below")) {
      shopItemsListPriceSearch = ItemsList.stream()
          .filter(e -> e.getPrice() < price)
          .collect(Collectors.toList());
    } else {
      shopItemsListPriceSearch = ItemsList.stream()
          .filter(e -> e.getPrice() == price)
          .collect(Collectors.toList());
    }
    model.addAttribute("items", shopItemsListPriceSearch);
    return "index4";
  }

  public List<ShopItems> fillItemsList() {
    shopItemsList.add(new ShopItems("Running shoes", "Nike running shoes for every" +
        " day sport", 500, 5, "clothes-and-shoes", "HUF"));
    shopItemsList.add(new ShopItems("Printer", "Some HP printer that will print " +
        "pages", 3000, 2, "electronics", "HUF"));
    shopItemsList.add(new ShopItems("Coca cola", "0.5l standard coke", 25,
        0, "beverages-and-snacks", "HUF"));
    shopItemsList.add(new ShopItems("Wokin", "Chicken with fried rice and WOKIN" +
        "sauce", 119, 100, "beverages-and-snacks", "HUF"));
    shopItemsList.add(new ShopItems("T-shirt", "Blue with a corgi on a bike",
        300, 1, "clothes-and-shoes", "HUF"));
    return shopItemsList;
  }
}
