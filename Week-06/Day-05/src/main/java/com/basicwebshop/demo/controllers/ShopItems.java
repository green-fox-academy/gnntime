package com.basicwebshop.demo.controllers;

import java.text.DecimalFormat;

public class ShopItems {

  private String name;
  private String description;
  private double price;
  private int quantityOfStock;
  private String type;

  public ShopItems(String name, String description, double price, int quantityOfStock, String type) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantityOfStock = quantityOfStock;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public double getPriceInEuro() {
    double euroPrice = getPrice() / 360;
    DecimalFormat format = new DecimalFormat("0.00");
    return Double.parseDouble(format.format(euroPrice));
  }

  public int getQuantityOfStock() {
    return quantityOfStock;
  }

  public String getType() {
    return type;
  }
}
