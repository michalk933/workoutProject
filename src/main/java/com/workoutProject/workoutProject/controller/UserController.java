package com.workoutProject.workoutProject.controller;


import com.workoutProject.workoutProject.entity.User;
import com.workoutProject.workoutProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

import java.util.List;

import static com.workoutProject.workoutProject.util.RequestMappingPath.BASE_PATH;
import static com.workoutProject.workoutProject.util.RequestMappingPath.USER_PATH;

@RestController
@RequestMapping(BASE_PATH + USER_PATH)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/{userName}")
    public User getUser(@NotNull @PathVariable String userName){
        return userService.getUserByUserName(userName);
    }

    @PostMapping("/create")
    public User createUser(@NotNull @RequestParam("user") User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@NotNull @RequestParam("user") User user){
        userService.deleteUser(user);
    }

    @DeleteMapping("/deleteAuthenticatedUser")
    public void deleteAuthenticatedUser(){
        userService.deleteAuthenticatedUser();
    }

    @GetMapping("/get")
    public String testUser(){
        return userService.getUserByUserName("acc1").getUserName();
    }
}
