package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;

public interface UserService {
  public User saveUser(User user);
  public User getUserById(int id);
}
