package com.greenfox.foxclubusers.repositories;

import com.greenfox.foxclubusers.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  User getUserByUserNameAndPassword(String userName, String password);
  User getUserById(Long id);
}
