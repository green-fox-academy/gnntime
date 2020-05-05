package com.greenfoxacademy.backendapi.models;

public class NumbersResultIntArray {
  private int[] result;

  public NumbersResultIntArray() {
  }

  public NumbersResultIntArray(int[] result) {
    this.result = result;
  }

  public void doubleTheNumbers(What what) {
    int[] resultArray = new int[what.getNumbers().length];
    for (int i = 0; i < what.getNumbers().length ; i++) {
      resultArray[i] = what.getNumbers()[i] * 2;
    }
    this.result = resultArray;
  }

  public int[] getResult() {
    return result;
  }

  public void setResult(int[] result) {
    this.result = result;
  }
}
