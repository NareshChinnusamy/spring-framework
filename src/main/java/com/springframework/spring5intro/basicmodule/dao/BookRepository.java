package com.springframework.spring5intro.basicmodule.dao;

import org.springframework.data.repository.CrudRepository;

import com.springframework.spring5intro.basicmodule.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
