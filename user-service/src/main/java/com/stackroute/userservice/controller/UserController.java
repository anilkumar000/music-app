package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class UserController {
  private UserService userService;


  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }


  @PostMapping("user")
  public ResponseEntity<?> saveUser(@RequestBody User user) {
    userService.saveUser(user);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @GetMapping("user")
  public ResponseEntity<?> getUserById(@RequestParam int id) {
    User retrievedUser=userService.getUserById(id);
    return new ResponseEntity<User>(retrievedUser,HttpStatus.OK);
  }
}
