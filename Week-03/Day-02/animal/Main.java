package animal;

public class Main {
  public static void main(String[] args) {

    Animal dog = new Animal();
    Animal snake = new Animal();
    dog.play();
    dog.eat();
    dog.drink();
    dog.play();
    snake.eat();
    System.out.println(dog.hunger);
    System.out.println(dog.thirst);
    System.out.println(snake.hunger);
  }
}
