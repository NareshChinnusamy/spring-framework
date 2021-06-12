package com.springframework.spring5intro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springframework.spring5intro.entity.UserRoleMap;

public interface UserRoleMapRepository extends JpaRepository<UserRoleMap, Long> {

}
