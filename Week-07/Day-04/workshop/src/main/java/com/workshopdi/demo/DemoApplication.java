package com.workshopdi.demo;

import com.workshopdi.demo.interfaces.MyColor;
import com.workshopdi.demo.services.Printer;
import com.workshopdi.demo.services.SpellChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

  private SpellChecker checker;
  private Printer printer;
  private MyColor color;

  @Autowired
  DemoApplication(SpellChecker checker, Printer printer, MyColor color) {
    this.checker = checker;
    this.printer = printer;
    this.color = color;
  }

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    checker.checkSpelling();
    printer.log("Something like that");
    color.printColor();
  }
}