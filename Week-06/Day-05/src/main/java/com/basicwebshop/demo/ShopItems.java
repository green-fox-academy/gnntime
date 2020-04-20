package com.basicwebshop.demo;

import java.text.DecimalFormat;

public class ShopItems {

  private String name;
  private String description;
  private double price;
  private int quantityOfStock;
  private String type;
  private String currency;

  public ShopItems(String name, String description, double price, int quantityOfStock, String type, String currency) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantityOfStock = quantityOfStock;
    this.type = type;
    this.currency = currency;
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

  public void setPriceToEuro() {
    price = price / 360;
  }

  public double getPriceInEuro() {
    double euroPrice = getPrice() / 360;
    DecimalFormat format = new DecimalFormat("0.00");
    return Double.parseDouble(format.format(euroPrice));
  }

  public String setAndGetCurrencyInEuro() {
    currency = "€";
    return currency;
  }

  public String setAndGetCurrencyInOriginal() {
    currency = "HUF";
    return currency;
  }

  public String getCurrency() {
    return currency;
  }

  public int getQuantityOfStock() {
    return quantityOfStock;
  }

  public String getType() {
    return type;
  }
}
