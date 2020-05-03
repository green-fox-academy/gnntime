package com.greenfox.foxclubusers.repositories;

import com.greenfox.foxclubusers.models.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long> {
}
