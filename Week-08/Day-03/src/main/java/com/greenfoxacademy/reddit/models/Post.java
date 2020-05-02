package com.greenfoxacademy.reddit.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {
  @Id
  @GeneratedValue
  private Long id;
  private String title;
  private String link;
  private int score;
  @ManyToOne
  private User user;

  public Post() {
    score = 1;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void incrementScore() {
    this.score++;
  }

  public void decrementScore() {
    if (this.score == 1) {
      setScore(1);
    } else {this.score--;}
  }
}
