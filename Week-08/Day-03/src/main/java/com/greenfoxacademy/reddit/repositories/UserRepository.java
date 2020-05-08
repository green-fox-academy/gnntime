package com.greenfoxacademy.reddit.repositories;

import com.greenfoxacademy.reddit.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  User getUserByName(String userName);
  User getUserById(Long id);
  boolean existsByName(String userName);
}
