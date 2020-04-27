package com.greenfoxacademy.todowithdatabase;

import com.greenfoxacademy.todowithdatabase.models.Todo;
import com.greenfoxacademy.todowithdatabase.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodowithdatabaseApplication implements CommandLineRunner {

  private TodoRepository todoRepository;

  @Autowired
  public TodowithdatabaseApplication(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(TodowithdatabaseApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    todoRepository.save(new Todo("daily task", false, false));
    todoRepository.save(new Todo("make the beds", true, true));
    todoRepository.save(new Todo("do the washing up", true, false));
    todoRepository.save(new Todo("clean the bathroom and the kitchen", true, true));
    todoRepository.save(new Todo("wipe all the surfaces with a cloth", true, false));
    todoRepository.save(new Todo("remove the grease", true, true));
    todoRepository.save(new Todo("tidy up", false, false));
    todoRepository.save(new Todo("throw away the rubbish", true, true));
    todoRepository.save(new Todo("broom", true, false));
    todoRepository.save(new Todo("sweep the floor", true, false));
    todoRepository.save(new Todo("wash the floors", true, false));
    todoRepository.save(new Todo("mop", true, true));
    todoRepository.save(new Todo("vacuum the carpet", true, false));
    todoRepository.save(new Todo("vacuum cleaner / hoover", false, false));
    todoRepository.save(new Todo("dust the furniture", false, false));
  }
}
