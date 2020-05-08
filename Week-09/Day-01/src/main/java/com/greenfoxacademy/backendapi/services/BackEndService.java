package com.greenfoxacademy.backendapi.services;

import com.greenfoxacademy.backendapi.models.AppendA;
import com.greenfoxacademy.backendapi.models.Doubling;
import com.greenfoxacademy.backendapi.models.Log;
import com.greenfoxacademy.backendapi.models.LogEntry;
import com.greenfoxacademy.backendapi.models.NumbersResultInt;
import com.greenfoxacademy.backendapi.models.NumbersResultIntArray;
import com.greenfoxacademy.backendapi.models.SithText;
import com.greenfoxacademy.backendapi.models.Text;
import com.greenfoxacademy.backendapi.models.Until;
import com.greenfoxacademy.backendapi.models.DountilResult;
import com.greenfoxacademy.backendapi.models.ErrorMessage;
import com.greenfoxacademy.backendapi.models.Greeter;
import com.greenfoxacademy.backendapi.models.What;
import com.greenfoxacademy.backendapi.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackEndService {
  private LogRepository logRepository;

  public BackEndService() {
  }

  @Autowired
  public BackEndService(LogRepository logRepository) {
    this.logRepository = logRepository;
  }

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

  public NumbersResultInt calculateSumOrMultiply(What what) {
    NumbersResultInt numbersResultInt = new NumbersResultInt();
    if (what.getWhat().equals("sum")) {
      numbersResultInt.sum(what);
    } else {
      numbersResultInt.multiply(what);
    }
    return numbersResultInt;
  }

  public NumbersResultIntArray calculateDouble(What what) {
    NumbersResultIntArray numbersResultIntArray = new NumbersResultIntArray();
    numbersResultIntArray.doubleTheNumbers(what);
    return numbersResultIntArray;
  }

  public void createLog(Log log) {
    logRepository.save(log);
  }

  public void saveLog(Log log) {
    logRepository.save(log);
  }

  public LogEntry getAllLogs() {
    LogEntry logEntry = new LogEntry();
    logEntry.setEntries(logRepository.findAll());
    logEntry.setEntry_count(logEntry.getEntries().size());
    return logEntry;
  }

  public SithText convertToSithText(Text text) {
    SithText sithText = new SithText();
    sithText.reverser(text);
    return sithText;
  }
}