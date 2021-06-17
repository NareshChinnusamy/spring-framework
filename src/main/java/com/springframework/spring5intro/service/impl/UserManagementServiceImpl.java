package com.springframework.spring5intro.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springframework.spring5intro.dao.RoleRepository;
import com.springframework.spring5intro.dao.UserRepository;
import com.springframework.spring5intro.dao.UserRoleMapRepository;
import com.springframework.spring5intro.dto.UserRoleDto;
import com.springframework.spring5intro.entity.Role;
import com.springframework.spring5intro.entity.User;
import com.springframework.spring5intro.entity.UserRoleMap;
import com.springframework.spring5intro.service.api.UserManagementService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleMapRepository userRoleMapRepository;

    @Override
    public User createUser(User user, List<Long> roleIds) {
        log.info("Entering createUser UserManagementService{}", user);
        user.setCreatedDate(Instant.now());
        user = userRepository.save(user);
        List<Role> roleLists = roleRepository.findByIdIn(roleIds);
        for (Role role : roleLists) {
            UserRoleMap userRoleMap = new UserRoleMap();
            userRoleMap.setUser_id(user.getId());
            userRoleMap.setRole(role);
            userRoleMap.setCreatedDate(Instant.now());
            userRoleMap = userRoleMapRepository.save(userRoleMap);
        }

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

    @Override
    public Role createRole(Role role) {
        log.info("Entering createRole UserManagementService{}", role);
        role.setCreatedDate(Instant.now());
        role = roleRepository.save(role);
        log.info("Leaving createRole UserManagementService{}", role);
        return role;
    }

    @Override
    public List<Role> retrieveAllRoles() {
        log.info("Entering retrieveAllUsers UserManagementService{}");
        List<Role> roles = roleRepository.findAll();
        log.info("Leaving retrieveAllUsers UserManagementService{}", roles);
        return roles;
    }

    @Override
    public UserRoleDto createUserRoleDto(JSONObject jsonObject) throws JSONException {
        UserRoleDto userRoleDto = new UserRoleDto();

        userRoleDto.setFirstName(jsonObject.get("firstName").toString());
        userRoleDto.setLastName(jsonObject.get("lastName").toString());
        userRoleDto.setEmailId(jsonObject.get("emailId").toString());
        userRoleDto.setAddress(jsonObject.get("address").toString());
        userRoleDto.setRoleName(jsonObject.get("roleName").toString());
        userRoleDto.setRoleDescription(jsonObject.get("roleDescription").toString());
        return userRoleDto;
    }

}
