package com.springframework.spring5intro.basicmodule.dao;

import org.springframework.data.repository.CrudRepository;

import com.springframework.spring5intro.basicmodule.entity.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
