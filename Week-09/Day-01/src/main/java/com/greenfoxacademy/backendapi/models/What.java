package com.greenfoxacademy.backendapi.models;

public class What {
  private String what;
  private int[] numbers;

  public What() {
  }

  public What(String what) {
    this.what = what;
  }

  public String getWhat() {
    return what;
  }

  public void setWhat(String what) {
    this.what = what;
  }

  public int[] getNumbers() {
    return numbers;
  }

  public void setNumbers(int[] numbers) {
    this.numbers = numbers;
  }
}
