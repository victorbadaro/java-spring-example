package com.example.javaspringexample.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> findOne(@PathVariable Long id) {
    Optional<User> foundUser = userRepository.findById(id);

    if (foundUser.isPresent()) {
      return ResponseEntity.ok().body(foundUser.get());
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public User create(@RequestBody User user) {
    return userRepository.save(user);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
    Optional<User> foundUser = userRepository.findById(id);

    if (foundUser.isPresent()) {
      foundUser.get().setName(user.getName());

      User updatedUser = userRepository.save(foundUser.get());

      return ResponseEntity.ok().body(updatedUser);
    }

    return ResponseEntity.notFound().build();
  }
}
