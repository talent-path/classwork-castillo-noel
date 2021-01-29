package com.tp.library.controller;


import com.tp.library.exceptions.*;
import com.tp.library.model.Book;
import com.tp.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    LibraryService service;

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable Integer bookId) throws InvalidBookIdException, NullBookIdException {
        return service.getBookById(bookId);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/books/title/{title}")
    public List<Book> getAllBooksByTitle(@PathVariable String title) throws NullBookTitleException {
        return service.getAllBooksByTitle(title);
    }

    @GetMapping("/books/author/{author}")
    public List<Book> getAllBooksByAuthor(@PathVariable String author) throws NullBookAuthorException {
        return service.getAllBooksByAuthor(author);
    }

    @GetMapping("/books/year/{year}")
    public List<Book> getAllBooksByYear(@PathVariable Integer year) throws NullBookYearException {
        return service.getAllBooksByYear(year);
    }

    @PostMapping("/books/new-book")
    public Book newBook(@RequestBody Book book) throws NullBookIdException, InvalidBookAuthorsException, InvalidBookYearException {
        return service.newBook(book);
    }

    @DeleteMapping("/books/delete/{bookId}")
    public String deleteBook(@PathVariable Integer bookId) throws InvalidBookIdException, NullBookIdException {
        service.deleteBook(bookId);
        return "Book " + bookId + " deleted";
    }

    @PutMapping("/books/{bookId}")
    public Book editBook(@PathVariable Integer bookId, @RequestBody Book book) throws InvalidBookIdException, NullBookIdException, InvalidBookAuthorsException {
        return service.editBook(bookId, book);

    }
}
