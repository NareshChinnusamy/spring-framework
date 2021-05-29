package com.springframework.spring5intro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springframework.spring5intro.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
