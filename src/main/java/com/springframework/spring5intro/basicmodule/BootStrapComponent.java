package com.springframework.spring5intro.basicmodule;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springframework.spring5intro.basicmodule.dao.AuthorRepository;
import com.springframework.spring5intro.basicmodule.dao.BookRepository;
import com.springframework.spring5intro.basicmodule.entity.Author;
import com.springframework.spring5intro.basicmodule.entity.Book;

@Component
public class BootStrapComponent implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BootStrapComponent(BookRepository bookRepository, AuthorRepository authorRepository) {
        super();
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book = new Book("Becoming", "good");
        Book book2 = new Book("Two states", "Average");
        Author author = new Author("Michelle", "Obama");
        Author author2 = new Author("Chethan", "Bagat");

        author.getBooks().add(book);
        book.getAuthors().add(author);

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        authorRepository.save(author);
        bookRepository.save(book);

        authorRepository.save(author2);
        bookRepository.save(book2);

        System.out.println("Total count " + bookRepository.count());
    }

}
