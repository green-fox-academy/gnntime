package gardenpractice;

import java.util.ArrayList;
import java.util.List;

public class Garden {

  private List<Plant> listOfPlants;

  public Garden() {
    listOfPlants = new ArrayList<>();
    Tree tree1 = new Tree( "purple");
    Tree tree2 = new Tree("orange");
    Flower flower1 = new Flower("yellow");
    Flower flower2 = new Flower("blue");
    listOfPlants.add(flower1);
    listOfPlants.add(flower2);
    listOfPlants.add(tree1);
    listOfPlants.add(tree2);
  }

  public void status() {
    for (Plant plant : listOfPlants) {
      plant.status();
    }
  }

  public void water(double waterAmount) {
    System.out.println("Watering with: " + (int)waterAmount);
    waterAmount = waterAmount / countHowManyNeedsWater();
    for (Plant plant: listOfPlants) {
      if (plant.needsWater()) {
        plant.water(waterAmount);
      }
    }
  }

  public int countHowManyNeedsWater() {
    int counter = 0;
    for (Plant plant: listOfPlants ) {
      if (plant.needsWater()) {
        counter++;
      }
    }
    return counter;
  }
}