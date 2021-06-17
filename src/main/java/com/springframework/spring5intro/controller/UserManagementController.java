package com.springframework.spring5intro.controller;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springframework.spring5intro.dao.RoleRepository;
import com.springframework.spring5intro.dao.UserRoleMapRepository;
import com.springframework.spring5intro.dto.UserRoleDto;
import com.springframework.spring5intro.entity.Role;
import com.springframework.spring5intro.entity.User;
import com.springframework.spring5intro.entity.UserRoleMap;
import com.springframework.spring5intro.service.api.UserManagementService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserManagementController {

    @Autowired
    UserManagementService userManagementService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleMapRepository userRoleMapRepository;

    @RequestMapping({ "/", "" })
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/createOrgUser", method = RequestMethod.GET)
    public String createUser(Model model) {
        log.info("Entering the createUser() controller------->");
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("user", new User());
        model.addAttribute("roles", roles);
        log.info("Leaving the createUser() controller------->");
        return "createUser";
    }

    @RequestMapping(value = "/createOrgUser", method = RequestMethod.POST)
    public ModelAndView createUser(@ModelAttribute("user") User user, Model model) {
        log.info("Entering the createUser() controller------->");
        List<Role> roles = roleRepository.findAll();
        log.info("userRoleId before {}", user.getUserRoleId());
        userManagementService.createUser(user, user.getUserRoleId());
        model.addAttribute("roles", roles);
        log.info("Leaving the createUser() controller------->");
        return new ModelAndView("redirect:/orgUsers");
    }

    @RequestMapping(value = "/orgUsers", method = RequestMethod.GET)
    public String retrieveUsers(Model model) {
        log.info("Entering the retrieveUsers() controller------->");
        List<User> users = userManagementService.retrieveAllUsers();
        model.addAttribute("users", users);
        log.info("Leaving the retrieveUsers() controller------->");
        return "userList";
    }

    @RequestMapping(value = "/orgUsers/{userId}", method = RequestMethod.GET)
    public String retrieveUserById(Model model, @PathVariable long userId) {
        log.info("Entering the retrieveUserById() controller------->");
        Optional<User> user = userManagementService.retrieveUserById(userId);
        model.addAttribute("user", user.get());
        log.info("Leaving the retrieveUserById() controller------->");
        return "viewUser";
    }

    @RequestMapping(value = "/createOrgRole", method = RequestMethod.GET)
    public String createRole(Model model) {
        log.info("Entering the createRole() controller------->");
        model.addAttribute("role", new Role());
        log.info("Leaving the createRole() controller------->");
        return "createRole";
    }

    @RequestMapping(value = "/createOrgRole", method = RequestMethod.POST)
    public ModelAndView createRole(@ModelAttribute("user") Role role, Model model) {
        log.info("Entering the post createRole() controller------->");
        userManagementService.createRole(role);
        log.info("Leaving the post createRole() controller------->");
        return new ModelAndView("redirect:/orgRoles");
    }

    @RequestMapping(value = "/orgRoles", method = RequestMethod.GET)
    public String retrieveRoles(Model model) {
        log.info("Entering the retrieveUsers() controller------->");
        List<Role> roles = userManagementService.retrieveAllRoles();
        model.addAttribute("roles", roles);
        log.info("Leaving the retrieveUsers() controller------->");
        return "roleList";
    }

    @RequestMapping(value = "/orgUserRoleMap", method = RequestMethod.GET)
    public String userRoleMap() {
        log.info("Entering the userRoleMap() controller------->");
        long id = 1;
        UserRoleMap userRoleMap = new UserRoleMap();
        Optional<Role> role = roleRepository.findById(id);
        userRoleMap.setRole(role.get());
        userRoleMap.setUser_id(id);
        userRoleMap.setCreatedDate(Instant.now());
        userRoleMap = userRoleMapRepository.save(userRoleMap);
        log.info("Leaving the userRoleMap() controller------->{}", userRoleMap);
        return "roleMap";
    }

    @RequestMapping(value = "/create/orgUserRoleDto", method = RequestMethod.GET)
    public String userRoleDto() {
        log.info("Entering the userRoleDto() controller------->");

        log.info("Leaving the userRoleDto() controller------->");
        return "userroledto";
    }

    @PostMapping("/orgUserRoleDto/create-user-role-dto")
    public ResponseEntity<?> createUserRoleDto(@Validated @RequestBody String createUserRole,
            HttpServletRequest request, HttpSession session) {
        log.info("Entering the createUserRoleDto controller------->");
        try {
            log.info("createUserRole {}", createUserRole);
            JSONObject jsonObject = new JSONObject(createUserRole);
            UserRoleDto userRoleDto = userManagementService.createUserRoleDto(jsonObject);
            log.info("Leaving the createUserRoleDto controller------->userRoleDto {}", userRoleDto);
            return ResponseEntity.ok("success");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
