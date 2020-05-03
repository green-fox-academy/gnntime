package com.greenfox.foxclubusers.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trick {
  @Id
  private Long id;
  private String name;

  public Trick() {
  }

  public Trick(String name) {
   this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
