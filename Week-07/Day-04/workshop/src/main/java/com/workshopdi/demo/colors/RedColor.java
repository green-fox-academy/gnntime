package com.workshopdi.demo.colors;

import com.workshopdi.demo.interfaces.MyColor;
import com.workshopdi.demo.services.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedColor implements MyColor {

  private Printer printer;

  @Autowired
  public RedColor(Printer printer) {
    this.printer = printer;
  }

  @Override
  public void printColor() {
    printer.log("This is a red color");
  }
}
