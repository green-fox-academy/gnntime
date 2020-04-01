package garden;

import java.util.ArrayList;
import java.util.List;

public class Garden {
  private List<Plant> listOfPlants = new ArrayList<>();

  public void addPlants(Plant plant){
    listOfPlants.add(plant);
  }
  public void watering(double waterAmount){
    double sharedWater = waterAmount / listOfPlants.size();
    System.out.println("Watering with " + (int)waterAmount);
    for (Plant plant: listOfPlants) {
      plant.water(sharedWater);
      plant.statusInfo();
    }
  }

}