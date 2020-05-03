package com.greenfox.foxclubusers.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String userName;
  private String password;
  @OneToMany
  private List<Creature> listOfCreatures = new ArrayList<>();

  public User() {
    Creature foxi = new Fox();
    foxi.setName("FoxiMuxi");
    foxi.setDiet(Arrays.asList(new Food("Banana"), new Food("Snickers")));
    foxi.setListOfTricks(Arrays.asList(new Trick("jumping"), new Trick("singing")));
    listOfCreatures.add(foxi);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Creature> getListOfCreatures() {
    return listOfCreatures;
  }

  public void setListOfCreatures(List<Creature> listOfCreatures) {
    this.listOfCreatures = listOfCreatures;
  }
}
