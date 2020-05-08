package com.greenfoxacademy.reddit.repositories;

import com.greenfoxacademy.reddit.models.ErrorMessage;
import org.springframework.data.repository.CrudRepository;

public interface ErrorMessageRepository extends CrudRepository <ErrorMessage, Long> {
  ErrorMessage getByMessageContains(String userName);
}
