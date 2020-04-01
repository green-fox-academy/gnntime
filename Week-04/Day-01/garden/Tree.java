package garden;

public class Tree extends Plant {

  public Tree(String color) {
    this.color = color;
    this.type = "tree";
    this.currentWaterlevel = 0;
    this.maxWaterlevel = 10;
    this.waterAbsorb = 0.4;
  }
}