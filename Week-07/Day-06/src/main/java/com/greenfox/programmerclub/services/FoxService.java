package com.greenfox.programmerclub.services;

import com.greenfox.programmerclub.models.Fox;
import com.greenfox.programmerclub.models.Trick;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxService {
  private Fox fox;
  private List<Fox> listOfFoxes;
  private List<Trick> listOfTricks;

  @Autowired
  public FoxService() {
    this.fox = new Fox();
    this.listOfFoxes = new ArrayList<>();
    this.listOfTricks = Arrays.asList(new Trick("jumping"), new Trick("singing"));
  }

  public Fox getFox() {
    return fox;
  }

  public List<Trick> getListOfTricks() {
    return listOfTricks;
  }

  public void setFoodAndDrink(String food, String drink) {
    this.fox.setFood(food);
    this.fox.setDrink(drink);
  }

  public void createAndAddToListOfFoxes(String name) {
    listOfFoxes.add(new Fox(name));
    loadActualFox(name);
    System.out.println("created new fox");
  }

  public void loadActualFox(String name) {
    for ( Fox foxSearch : listOfFoxes) {
      if (foxSearch.getName().equals(name)) {
        this.fox = foxSearch;
      }
    }
  }

  public void addTrickWithGivenName(String trick) {
    fox.addATrick(new Trick(trick));
  }

  public boolean doesListOfFoxesContainFoxName(String name) {
    loadActualFox(name);
    System.out.println("selected the fox");
    return listOfFoxes.stream().anyMatch(fox -> fox.getName().equals(name));
  }


}