package com.springframework.spring5intro.service.api;

import java.util.List;
import java.util.Optional;

import com.springframework.spring5intro.entity.Role;
import com.springframework.spring5intro.entity.User;

public interface UserManagementService {
    User createUser(User user, List<Long> userRoleId);

    List<User> retrieveAllUsers();

    Optional<User> retrieveUserById(long userId);

    User deleteUserById(long userId);

    Role createRole(Role role);

    List<Role> retrieveAllRoles();

}
