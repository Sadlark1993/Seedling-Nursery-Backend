package com.ifmt.seedlingNursery.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifmt.seedlingNursery.Model.User;
import com.ifmt.seedlingNursery.Service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
  UserService userService;

  @PostMapping("/register")
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    userService.saveUser(user);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}