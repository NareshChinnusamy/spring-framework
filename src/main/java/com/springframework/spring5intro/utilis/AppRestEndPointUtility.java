package com.springframework.spring5intro.utilis;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.spring5intro.dao.RoleRepository;
import com.springframework.spring5intro.dao.UserRoleMapRepository;
import com.springframework.spring5intro.entity.Role;
import com.springframework.spring5intro.entity.UserRoleMap;
import com.springframework.spring5intro.service.api.UserManagementService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/org-utils/")
public class AppRestEndPointUtility {

    @Autowired
    UserManagementService userManagementService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleMapRepository userRoleMapRepository;

    @PostMapping("/orgUserRoleMap")
    public void userRoleMap() {
        log.info("Entering the userRoleMap() controller------->");
        long id = 1;
        UserRoleMap userRoleMap = new UserRoleMap();
        Optional<Role> role = roleRepository.findById(id);
        userRoleMap.setRole(role.get());
        userRoleMap.setUser_id(id);
        userRoleMap.setCreatedDate(Instant.now());
        userRoleMap = userRoleMapRepository.save(userRoleMap);
        log.info("Leaving the userRoleMap() controller------->{}", userRoleMap);
    }
}
