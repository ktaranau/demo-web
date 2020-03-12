package com.jolly.springboot.crud.service;

import com.jolly.springboot.crud.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(User user);

}
