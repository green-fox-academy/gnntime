package com.greenfox.foxclubusers.repositories;

import com.greenfox.foxclubusers.models.Creature;
import org.springframework.data.repository.CrudRepository;

public interface CreatureRepository extends CrudRepository<Creature, Long> {
}
