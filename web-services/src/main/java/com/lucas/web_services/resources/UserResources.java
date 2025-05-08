package com.lucas.web_services.resources;

import com.lucas.web_services.model.User;
import com.lucas.web_services.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

  private final UserServices userServices;

  public UserResources(UserServices userServices) {
    this.userServices = userServices;
  }

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    List<User> userList = userServices.findAll();
    return ResponseEntity.ok().body(userList);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id) {
    User user = userServices.findById(id);
    return ResponseEntity.ok().body(user);
  }
}
