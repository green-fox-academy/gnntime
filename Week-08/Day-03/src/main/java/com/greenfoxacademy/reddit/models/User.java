package com.greenfoxacademy.reddit.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn
  private List<Post> posts = new ArrayList<>();
  private int karma;

  public User() {
  }

  public User(String name) {
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

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  public int getKarma() {
    return karma;
  }

  public void setKarma(int karma) {
    this.karma = karma;
  }

  public void incrementKarma() {
    this.karma++;
  }

  public void decrementKarma() {
    this.karma--;
  }
}
