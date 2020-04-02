package exercises;

import static org.junit.Assert.*;


import org.junit.Test;

public class AnimalTest {


  @Test
  public void eat() {
    Animal animal = new Animal();
    animal.eat();
  assertEquals(49, animal.hunger);
  }

  @Test
  public void drink() {
    Animal animal = new Animal();
    animal.drink();
    assertEquals(49, animal.thirst);
  }

  @Test
  public void play() {
    Animal animal = new Animal();
    animal.play();
    assertEquals(51, animal.hunger);
    assertEquals(51, animal.thirst);
  }

  @Test
  public void getHunger() {
    Animal animal = new Animal();
    assertEquals(50, animal.getHunger());
  }

  @Test
  public void getName() {
    Animal animal = new Animal();
    assertEquals("dog", animal.getName());
  }
}