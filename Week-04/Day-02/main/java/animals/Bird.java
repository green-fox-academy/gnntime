package main.java.animals;

public class Bird extends Animal {

  public Bird(String name) {
    this.name = name;
    this.numberOfLegs = 2;
    this.breed = "laying eggs";
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String breed() {
    return this.breed;
  }
}