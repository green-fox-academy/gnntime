package animal;

public class Main {
  public static void main(String[] args) {
    Farm farm = new Farm();

    farm.breed();
    farm.breed();
    farm.breed();
    farm.breed();
    farm.breed();
    System.out.println(farm.listOfAnimals.size());
    farm.listOfAnimals.get(1).eat();
    farm.listOfAnimals.get(1).eat();
    farm.listOfAnimals.get(4).eat();
    farm.listOfAnimals.get(4).eat();
    farm.listOfAnimals.get(4).eat();
    farm.listOfAnimals.get(3).play();
    farm.slaughter();
    farm.breed();
    farm.breed();
    farm.breed();
    System.out.println(farm.listOfAnimals.size());
    farm.breed();
    System.out.println(farm.listOfAnimals.size());
  }
}
