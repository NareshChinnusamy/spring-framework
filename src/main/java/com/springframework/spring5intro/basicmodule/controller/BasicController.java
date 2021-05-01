package com.springframework.spring5intro.basicmodule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframework.spring5intro.basicmodule.dao.BookRepository;

@Controller
public class BasicController {

    private final BookRepository bookRepository;

    public BasicController(BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String retrieveBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());
        return "list";
    }
}
