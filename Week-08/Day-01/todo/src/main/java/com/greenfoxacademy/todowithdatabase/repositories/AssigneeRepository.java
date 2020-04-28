package com.greenfoxacademy.todowithdatabase.repositories;

import com.greenfoxacademy.todowithdatabase.models.Assignee;
import org.springframework.data.repository.CrudRepository;

public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
  void deleteById(Long id);
  Assignee getAssigneeById(Long id);
}
