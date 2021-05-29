package com.springframework.spring5intro.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springframework.spring5intro.dao.UserRepository;
import com.springframework.spring5intro.entity.User;
import com.springframework.spring5intro.service.api.UserManagementService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        log.info("Entering createUser UserManagementService{}", user);
        user = new User();
        user.setFirstName("Sugan");
        user.setLastName("Vellingiri");
        user.setEmailId("sugan@breezeware.net");
        user.setAddress("wisconsin");
        user.setPhoneNumber("45224223");
        user.setCreatedDate(Instant.now());

        user = userRepository.save(user);
        log.info("Leaving createUser UserManagementService{}", user);
        return user;
    }

    @Override
    public List<User> retrieveAllUsers() {
        log.info("Entering retrieveAllUsers UserManagementService{}");
        List<User> users = userRepository.findAll();
        log.info("Leaving retrieveAllUsers UserManagementService{}", users);
        return users;
    }

    @Override
    public Optional<User> retrieveUserById(long userId) {
        log.info("Entering retrieveUserById UserManagementService{}");
        Optional<User> user = userRepository.findById(userId);
        log.info("Leaving retrieveUserById UserManagementService{}", user.toString());
        return user;
    }

    @Override
    public User deleteUserById(long userId) {
        // TODO Auto-generated method stub
        return null;
    }

}
