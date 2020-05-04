package com.greenfoxacademy.backendapi.models;

public class DountilResult {
  private int result;

  public DountilResult() {
  }

  public void sum(Until until) {
    int result = until.getUntil();
    for (int i = 0; i < until.getUntil() ; i++) {
      result = result + i;
    }
    this.result = result;
  }

  public void factor(Until until) {
    int result = until.getUntil();
    for (int i = 1; i < until.getUntil() ; i++) {
      result = result * i;
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
