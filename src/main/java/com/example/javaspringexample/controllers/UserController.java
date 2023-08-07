package com.example.javaspringexample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaspringexample.models.User;
import com.example.javaspringexample.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<User> find() {
    return userRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public User create(@RequestBody User user) {
    return userRepository.save(user);
  }
}
