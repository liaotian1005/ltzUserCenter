package com.service;

import com.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  Boolean register(User user);

  String  login(String username, String password);
}
