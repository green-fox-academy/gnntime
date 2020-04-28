package com.greenfoxacademy.todowithdatabase;

import com.greenfoxacademy.todowithdatabase.models.Todo;
import com.greenfoxacademy.todowithdatabase.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodowithdatabaseApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(TodowithdatabaseApplication.class, args);
  }

  @Override
  public void run(String... args) {
  }
}
