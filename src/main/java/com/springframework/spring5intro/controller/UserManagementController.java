package com.springframework.spring5intro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springframework.spring5intro.entity.User;
import com.springframework.spring5intro.service.api.UserManagementService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserManagementController {

    @Autowired
    UserManagementService userManagementService;

    @RequestMapping("/createUser")
    public String createUser(Model model) {
        log.info("Entering the createUser() controller------->");
        User user = new User();
        User passUser = userManagementService.createUser(user);
        model.addAttribute("user", passUser);
        log.info("Leaving the createUser() controller------->");
        return "createUser";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String retrieveUsers(Model model) {
        log.info("Entering the retrieveUsers() controller------->");
        List<User> users = userManagementService.retrieveAllUsers();
        model.addAttribute("users", users);
        log.info("Leaving the retrieveUsers() controller------->");
        return "userList";
    }

    @RequestMapping(value = "/orgUser/{userId}", method = RequestMethod.GET)
    public String retrieveUserById(Model model, @PathVariable long userId) {
        log.info("Entering the retrieveUserById() controller------->");
        Optional<User> user = userManagementService.retrieveUserById(userId);
        model.addAttribute("user", user.get());
        log.info("Leaving the retrieveUserById() controller------->");
        return "viewUser";
    }
}
