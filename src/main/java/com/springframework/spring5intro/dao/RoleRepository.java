package com.springframework.spring5intro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springframework.spring5intro.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByIdIn(List<Long> ids);
}
