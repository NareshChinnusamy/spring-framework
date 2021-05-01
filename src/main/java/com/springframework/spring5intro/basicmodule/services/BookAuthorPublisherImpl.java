package com.springframework.spring5intro.basicmodule.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springframework.spring5intro.basicmodule.dao.AuthorRepository;
import com.springframework.spring5intro.basicmodule.dao.BookRepository;
import com.springframework.spring5intro.basicmodule.dao.PublisherRepository;
import com.springframework.spring5intro.basicmodule.entity.Author;
import com.springframework.spring5intro.basicmodule.entity.Book;
import com.springframework.spring5intro.basicmodule.entity.Publisher;

@Component
public class BookAuthorPublisherImpl implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookAuthorPublisherImpl(BookRepository bookRepository, AuthorRepository authorRepository,
            PublisherRepository publisherRepository) {
        super();
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book = new Book("Becoming", "good");
        Book book2 = new Book("Two states", "Average");

        Author author = new Author("Michelle", "Obama");
        Author author2 = new Author("Chethan", "Bagat");

        Publisher publisher = new Publisher();
        publisher.setName("Marvel publishing");
        publisher.setAddress("Sunset Boulevard");
        publisher.setCity("california");
        publisherRepository.save(publisher);

        author.getBooks().add(book);
        book.getAuthors().add(author);
        book.setPublisher(publisher);

        publisher.getBooks().add(book);

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);
        book2.setPublisher(publisher);

        authorRepository.save(author);
        bookRepository.save(book);

        authorRepository.save(author2);
        bookRepository.save(book2);

        System.out.println("Total number of books" + bookRepository.count());
        System.out.println("Number of books for publisher " + publisher.getBooks().size());

    }

}
