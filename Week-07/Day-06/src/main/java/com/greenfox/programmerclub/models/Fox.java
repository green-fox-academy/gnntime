package com.greenfox.programmerclub.models;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Fox {

  private String name;
  private List<Trick> listOfTricks;
  private String food;
  private String drink;

  public Fox() {
    name = "Karak";
    food = "bread";
    listOfTricks = new ArrayList<>();
    drink = "lemonade";
  }

  public Fox(String name) {
    this.name = name;
    food = "bread";
    listOfTricks = new ArrayList<>();
    drink = "lemonade";
  }

  public Fox(String name, String food, String drink) {
    this.name = name;
    this.food = food;
    this.drink = drink;
  }

  public String getName() {
    return name;
  }

  public List<Trick> getListOfTricks() {
    return listOfTricks;
  }

  public void addATrick(Trick trick) {
    listOfTricks.add(trick);
  }

  public String getFood() {
    return food;
  }

  public void setFood(String food) {
    this.food = food;
  }

  public String getDrink() {
    return drink;
  }

  public void setDrink(String drink) {
    this.drink = drink;
  }
}