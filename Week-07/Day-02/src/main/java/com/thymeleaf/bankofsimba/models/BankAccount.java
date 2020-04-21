package com.thymeleaf.bankofsimba.models;

public class BankAccount {

  private String name;
  private int balance;
  private String animalType;
  private boolean isKing;
  private boolean bad;

  public BankAccount(String name, int balance, String animalType, boolean isKing, boolean bad) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    this.isKing = isKing;
    this.bad = bad;
  }

  public boolean isBad() {
    return bad;
  }

  public void setBad(boolean bad) {
    this.bad = bad;
  }


  public String getKingConditional() {
    return isKing ? "yes" : "no";
  }

  public boolean isKing() {
    return isKing;
  }

  public void setKing(boolean king) {
    isKing = king;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public String getAnimalType() {
    return animalType;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }

  public void raiseBalance() {
    if (isKing) {
      balance = balance + 100;
    } else {
      balance = balance +10;
    }
  }
}
