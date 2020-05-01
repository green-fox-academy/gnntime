package com.greenfoxacademy.todowithdatabase.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String content;
  private String description;
  private boolean urgent;
  private boolean done;
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date dateOfCreation = new Date();
  private String dueDate;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private Assignee assignee;

  public Todo() {
  }

  public Todo(String title) {
    this.title = title;
  }

  public Todo(String title, boolean urgent, boolean done) {
    this.title = title;
    this.urgent = urgent;
    this.done = done;
  }

  public Todo(String title, String content, String description, boolean urgent, boolean done) {
    this.title = title;
    this.content = content;
    this.description = description;
    this.urgent = urgent;
    this.done = done;
  }

  public Todo(String title, String content, String description, boolean urgent, boolean done,
              String dueDate) {
    this.title = title;
    this.content = content;
    this.description = description;
    this.urgent = urgent;
    this.done = done;
    this.dueDate = dueDate;
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

  public boolean isUrgent() {
    return urgent;
  }

  public boolean isDone() {
    return done;
  }

  public String getContent() {
    return content;
  }

  public String getDescription() {
    return description;
  }

  public Assignee getAssignee() {
    return assignee;
  }

  public void setAssignee(Assignee assignee) {
    this.assignee = assignee;
  }

  public Date getDateOfCreation() {
    return dateOfCreation;
  }

  public String getDueDate() {
    return dueDate;
  }

}
