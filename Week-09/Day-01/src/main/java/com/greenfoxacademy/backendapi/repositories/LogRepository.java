package com.greenfoxacademy.backendapi.repositories;

import com.greenfoxacademy.backendapi.models.Log;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Log, Long> {
  List<Log> findAll();
}
