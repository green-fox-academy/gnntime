package gardenpractice;

public abstract class Plant {

  protected String color;
  protected String type;
  protected double waterAbsorb;
  protected double currentWater;
  protected double maxWater;

  public void status() {
    if (currentWater < maxWater){
      System.out.println("The " + this.color + " " + this.type + " needs water. ");
    } else {
      System.out.println("The " + this.color + " " + this.type + " does't need water. ");
    }
  }

  public void water(double waterAmount) {
    currentWater = (currentWater + waterAmount) * waterAbsorb;
  }

  public boolean needsWater() {
    return currentWater < maxWater;
  }
}