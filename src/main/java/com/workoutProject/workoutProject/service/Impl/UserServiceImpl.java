package com.workoutProject.workoutProject.service.Impl;

import com.workoutProject.workoutProject.entity.User;
import com.workoutProject.workoutProject.exception.UserAlreadyExistException;
import com.workoutProject.workoutProject.exception.UserNotExistException;
import com.workoutProject.workoutProject.repository.UserRepository;
import com.workoutProject.workoutProject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = Optional.ofNullable(userRepository.findByUserName(userName))
                .orElseThrow(() -> new UsernameNotFoundException(format("Invalid userName or Password, for = {}", userName)));

        log.info("Find user = {}",user);

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }

    @Override
    public User getUserByUserName(String userName) {
        return Optional.ofNullable(userRepository.findByUserName(userName))
                .orElseThrow(() -> new UserNotExistException(format("User not exist with name = {} ",userName)));
    }

    @Override
    public User createUser(User user) {
        if (!userRepository.isExist(user.getUserName())){
            return userRepository.save(user);
        }
        throw new UserAlreadyExistException(format("User already exists, for user = {}", user ));
    }

    @Override
    public List<User> getUsers() {
        log.info("Get users");
        return Optional.ofNullable(userRepository.findAll())
                .orElseThrow(() -> new UserNotExistException("Users not founds"));
    }

    @Transactional
    @Override
    public void deleteAuthenticatedUser() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = getUserByUserName(userName);
        log.info("Delete authenticated user = {}",user);
        userRepository.delete(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user){
        log.info("Delete user = {}",user);
        userRepository.delete(user);
    }


}
