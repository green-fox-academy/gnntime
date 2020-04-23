package com.workshopdi.demo.colors;

import com.workshopdi.demo.interfaces.MyColor;
import com.workshopdi.demo.services.Printer;
import org.springframework.beans.factory.annotation.Autowired;

public class BlueColor implements MyColor {

  private Printer printer;

  @Autowired
  public BlueColor(Printer printer) {
    this.printer = printer;
  }

  @Override
  public void printColor() {
    printer.log("It's a blue color");
  }
}
