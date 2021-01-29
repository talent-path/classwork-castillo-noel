package com.tp.library.controller;


import com.tp.library.exceptions.InvalidBookIdException;
import com.tp.library.exceptions.NullBookIdException;
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

    @PostMapping("/books/new-book")
    public Book newBook(@RequestBody Book book) {
        return service.newBook(book);
    }

    @DeleteMapping("/books/delete/{bookId}")
    public String deleteBook(@PathVariable Integer bookId) throws InvalidBookIdException {
        service.deleteBook(bookId);
        return "Book " + bookId + " deleted";
    }

    @PutMapping("/books/{bookId}")
    public Book editBook(@PathVariable Integer bookId, @RequestBody Book book) throws InvalidBookIdException, NullBookIdException {
        return service.editBook(bookId, book);

    }
}
