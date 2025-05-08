package com.lucas.web_services.services;

import com.lucas.web_services.model.User;
import com.lucas.web_services.repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

  private final UserRepository userRepository;

  public UserServices(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(Long id) {
    Optional<User> userOptional = userRepository.findById(id);
    return userOptional.get();
  }
}
