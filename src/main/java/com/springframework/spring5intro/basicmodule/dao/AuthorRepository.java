package com.springframework.spring5intro.basicmodule.dao;

import org.springframework.data.repository.CrudRepository;

import com.springframework.spring5intro.basicmodule.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
