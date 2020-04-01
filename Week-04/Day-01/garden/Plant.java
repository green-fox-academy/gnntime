package garden;

public abstract class Plant {
  protected double currentWaterlevel;
  protected double maxWaterlevel;
  protected String color;
  protected String type;
  protected double waterAbsorb;

  public void statusInfo(){
    if (this.currentWaterlevel < this.maxWaterlevel){
      System.out.println("The " + color + " " + type + " needs water.");
    }else
      System.out.println("The " + color + " " + type + " doesnt need water.");
  }

  public void water(double waterQuantity){
    currentWaterlevel += waterAbsorb * waterQuantity;
  }
}