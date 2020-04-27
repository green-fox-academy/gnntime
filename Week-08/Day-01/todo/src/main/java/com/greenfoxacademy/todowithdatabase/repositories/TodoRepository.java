package com.greenfoxacademy.todowithdatabase.repositories;

import com.greenfoxacademy.todowithdatabase.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
  Iterable<Todo> getTodosByDoneIsFalse();
  Todo getTodoById(Long id);
}
