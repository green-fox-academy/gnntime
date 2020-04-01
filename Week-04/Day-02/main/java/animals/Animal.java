package main.java.animals;

public abstract class Animal {

  protected String name;
  protected int age;
  protected String gender;
  protected int numberOfLegs;
  protected boolean isPredator;
  protected String breed;

  public abstract String getName();
  public abstract String breed();
}
