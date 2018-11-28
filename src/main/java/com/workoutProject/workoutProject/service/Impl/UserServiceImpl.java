package com.workoutProject.workoutProject.service.Impl;

import com.workoutProject.workoutProject.entity.User;
import com.workoutProject.workoutProject.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = Optional.ofNullable(userRepository.findByUserName(userName))
                .orElseThrow(() -> new UsernameNotFoundException("Invalid userName or Password"));

        log.info("Find user = {}",user);

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));

        return userDetails;
    }
}
