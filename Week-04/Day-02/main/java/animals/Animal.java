package main.java.animals;

public abstract class Animal {

  String name;
  int age;
  String gender;
  int numberOfLegs;

  public abstract String getName();

  public abstract String breed();

  public abstract String walk();
}
