package com.workoutProject.workoutProject.service;

import com.workoutProject.workoutProject.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    UserDetails loadUserByUsername(String userName);

    User getUserByUserName(String userName);

    User createUser(User user);

    List<User> getUsers();

    void deleteAuthenticatedUser();

    void deleteUser(User user);

}
