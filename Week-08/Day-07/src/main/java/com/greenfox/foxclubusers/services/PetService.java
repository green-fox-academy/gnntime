package com.greenfox.foxclubusers.services;

import com.greenfox.foxclubusers.models.Food;
import com.greenfox.foxclubusers.models.Fox;
import com.greenfox.foxclubusers.models.Trick;
import com.greenfox.foxclubusers.models.User;
import com.greenfox.foxclubusers.repositories.CreatureRepository;
import com.greenfox.foxclubusers.repositories.FoodRepository;
import com.greenfox.foxclubusers.repositories.TrickRepository;
import com.greenfox.foxclubusers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {
  private CreatureRepository creatureRepository;
  private FoodRepository foodRepository;
  private TrickRepository trickRepository;
  private UserRepository userRepository;

  @Autowired
  public PetService(CreatureRepository creatureRepository,
                    FoodRepository foodRepository,
                    TrickRepository trickRepository,
                    UserRepository userRepository) {
    this.creatureRepository = creatureRepository;
    this.foodRepository = foodRepository;
    this.trickRepository = trickRepository;
    this.userRepository = userRepository;
  }

  public void createUser(User user) {
    userRepository.save(user);
    trickRepository.save(new Trick("jumping"));
    foodRepository.save(new Food("bananas"));
    creatureRepository.save(new Fox());
  }

  public User fetchUserByNameAndPassword(String userName, String password) {
    return userRepository.getUserByUserNameAndPassword(userName, password);
  }

  public User getUserById(Long id) {
    return userRepository.getUserById(id);
  }
}
