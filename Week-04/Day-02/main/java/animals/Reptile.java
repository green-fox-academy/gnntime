package main.java.animals;

public class Reptile extends Animal {

  public Reptile(String name) {
    this.name = name;
    this.gender = "male";
    this.breed = "lays eggs";
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
