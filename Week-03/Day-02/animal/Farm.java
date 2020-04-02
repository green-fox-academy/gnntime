package animal;

import java.util.ArrayList;
import java.util.List;

public class Farm {
  /*
  Reuse your Animal class
  Create a Farm class
  it has list of Animals
  it has slots which defines the number of free places for animals
  breed() -> creates a new animal if there's place for it
  slaughter() -> removes the least hungry animal
   */

  protected List<Animal> listOfAnimals = new ArrayList<>();
  protected int freeSlots = 10;

  public void breed() {
    if (freeSlots == 0) {
      System.out.println("Can't breed any more animals!");
    } else {
      Animal animal = new Animal();
      listOfAnimals.add(animal);
      freeSlots--;
    }
  }

  public void add(Animal animal) {
  listOfAnimals.add(animal);
  }

  public void slaughter() {
    Animal fedAnimal = new Animal();
    for (Animal animal : this.listOfAnimals) {
      if (animal.hunger < fedAnimal.hunger) {
        fedAnimal = animal;
      }
    }
    listOfAnimals.remove(listOfAnimals.indexOf(fedAnimal));
    freeSlots++;
  }
}
