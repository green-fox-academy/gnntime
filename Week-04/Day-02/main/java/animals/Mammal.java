package main.java.animals;

public class Mammal extends Animal {

  public Mammal(String name) {
  this.name = name;
  this.isPredator = true;
  this.age = 2;
  this.breed = "giving birth";
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
