package gardenpractice;

public class Tree extends Plant {

  Tree(String color) {
    this.color = color;
    this.type = "Tree";
    this.currentWater = 0;
    this.waterAbsorb = 0.40;
    this.maxWater = 10;
  }
}