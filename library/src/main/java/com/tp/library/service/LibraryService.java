package com.tp.library.service;


import com.tp.library.exceptions.InvalidBookIdException;
import com.tp.library.exceptions.NullBookIdException;
import com.tp.library.model.Book;
import com.tp.library.persistence.LibraryInMemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    LibraryInMemDAO dao;

    public Book getBookById(Integer bookId) throws InvalidBookIdException, NullBookIdException {
        return dao.getBookById(bookId);
    }

    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    public Book newBook(Book book) {
        return dao.newBook(book);
    }


    public void deleteBook(Integer bookId) throws InvalidBookIdException {
        dao.deleteBook(bookId);
    }

    public Book editBook(Book currentBook, Book updatedBook) {

        return dao.editBook(currentBook, updatedBook);
    }


}
