package com.greenfoxacademy.backendapi.models;

public class Doubling {
  private int received;
  private int result;

  public Doubling() {
  }

  public void duplify(int inputNumber) {
    this.received = inputNumber;
    this.result = inputNumber * 2;
  }

  public int getReceived() {
    return received;
  }

  public void setReceived(int received) {
    this.received = received;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }
}
