package com.greenfoxacademy.backendapi;

import com.greenfoxacademy.backendapi.models.DountilResult;
import com.greenfoxacademy.backendapi.models.Until;
import com.greenfoxacademy.backendapi.models.What;
import com.greenfoxacademy.backendapi.services.BackEndService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BackEndServiceTests {

  @Test
  public void calculateSumOrMultiplyWithSumTest() {
    //Arrange
    BackEndService backEndService = new BackEndService();
    What what = new What();
    what.setWhat("sum");
    int[] testIntArray = {2, 3, 4};
    what.setNumbers(testIntArray);
    //Act
    backEndService.calculateSumOrMultiply(what);
    //Assert
    Assertions.assertEquals(9, backEndService.calculateSumOrMultiply(what).getResult());
  }

  @Test
  public void calculateSumOrMultiplyWithMultiplyTest() {
    BackEndService backEndService = new BackEndService();
    What what = new What();
    what.setWhat("multiply");
    int[] testIntArray = {1, 3, 6};
    what.setNumbers(testIntArray);
    Assertions.assertEquals(18, backEndService.calculateSumOrMultiply(what).getResult());
  }

  @Test
  public void calculateDouble() {
    BackEndService backEndService = new BackEndService();
    What what = new What();
    what.setWhat("double");
    int[] testIntArray = {5, 100, 2};
    int[] resultIntArray = {10, 200, 4};
    what.setNumbers(testIntArray);
    Assertions.assertArrayEquals(resultIntArray, backEndService.calculateDouble(what).getResult());
  }

  @Test
  public void doublingTest() {
    BackEndService backEndService = new BackEndService();
    Assertions.assertEquals(20, backEndService.doubleTheNumber(10).getResult());
  }

  @Test
  public void AppendATest() {
    BackEndService backEndService = new BackEndService();
    Assertions.assertEquals("baba", backEndService.appendWordWithA("bab").getAppended());
  }

  @Test
  public void doUntilWithSumTest() {
    BackEndService backEndService = new BackEndService();
    Until testUntil = new Until();
    testUntil.setUntil(6);
    Assertions.assertEquals(21, backEndService.sum(testUntil).getResult());
  }

  @Test
  public void doUntilWithFactorialObjectAssertionTest() {
    BackEndService backEndService = new BackEndService();
    Until testUntil = new Until();
    testUntil.setUntil(5);
    DountilResult testDoUntilResult = new DountilResult();
    testDoUntilResult.setResult(120);
    Assertions.assertEquals(testDoUntilResult.getResult(), backEndService.factor(testUntil).getResult());
  }

  @Test
  public void greeterTest() {
    BackEndService backEndService = new BackEndService();
    Assertions.assertEquals("Oh, hi there Zoli, my dear Kiraly!",
        backEndService.sendGreeterWithNameAndTitle("Zoli", "Kiraly").getWelcome_message());
  }
}
