package com.example.javaspringexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javaspringexample.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
