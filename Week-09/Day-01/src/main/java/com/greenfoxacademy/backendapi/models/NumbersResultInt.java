package com.greenfoxacademy.backendapi.models;

public class NumbersResultInt {
  private int result;

  public NumbersResultInt() {
  }

  public NumbersResultInt(int result) {
    this.result = result;
  }

  public void sum(What what){
    int result = 0;
    for (int number : what.getNumbers()) {
      result = result + number;
    }
    this.result = result;
  }

  public void multiply(What what) {
    int result = 1;
    for (int number : what.getNumbers()) {
      result = result * number;
    }
    this.result = result;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }
}
