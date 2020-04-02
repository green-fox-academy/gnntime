package exercises;

public class Animal {
  protected String name;
  protected int hunger;
  protected int thirst;

  public Animal() {
    this.name = "dog";
    this.hunger = 50;
    this.thirst = 50;
  }
  public void eat() {
    this.hunger -= 1;
  }
  public void drink() {
    thirst -= 1;
  }
  public void play() {
    hunger += 1;
    thirst += 1;
  }

  public int getHunger() {
    return hunger;
  }

  public String getName() {
    return name;
  }
}