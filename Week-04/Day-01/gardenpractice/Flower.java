package gardenpractice;

public class Flower extends Plant {

  Flower(String color) {
    this.color = color;
    this.type = "Flower";
    this.currentWater = 0;
    this.waterAbsorb = 0.75;
    this.maxWater = 5;
  }
}