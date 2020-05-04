package com.greenfoxacademy.backendapi.services;

import com.greenfoxacademy.backendapi.models.AppendA;
import com.greenfoxacademy.backendapi.models.Doubling;
import com.greenfoxacademy.backendapi.models.Until;
import com.greenfoxacademy.backendapi.models.DountilResult;
import com.greenfoxacademy.backendapi.models.ErrorMessage;
import com.greenfoxacademy.backendapi.models.Greeter;
import org.springframework.stereotype.Service;

@Service
public class BackEndService {

  public Doubling doubleTheNumber(int inputNumber) {
    Doubling doubling = new Doubling();
    doubling.duplify(inputNumber);
    return doubling;
  }

  public ErrorMessage sendErrorMessage(String message) {
    return new ErrorMessage(message);
  }

  public Greeter sendGreeterWithNameAndTitle(String name, String title) {
    return new Greeter(name, title);
  }

  public AppendA appendWordWithA(String appended) {
    return new AppendA(appended);
  }

  public DountilResult sum(Until until) {
    DountilResult result = new DountilResult();
    result.sum(until);
    return result;
  }

  public DountilResult factor(Until until) {
    DountilResult result = new DountilResult();
    result.factor(until);
    return result;
  }
}
