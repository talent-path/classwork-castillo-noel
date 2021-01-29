package com.tp.library.service;


import com.tp.library.exceptions.*;
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

    public List<Book> getAllBooksByTitle(String title) throws NullBookTitleException {
        return dao.getAllBooksByTitle(title);
    }

    public List<Book> getAllBooksByAuthor(String author) throws NullBookAuthorException {
        return dao.getAllBooksByAuthor(author);
    }

    public List<Book> getAllBooksByYear(Integer year) throws NullBookYearException {
        return dao.getAllBooksByYear(year);
    }

    public Book newBook(Book book) throws NullBookIdException, InvalidBookAuthorsException, InvalidBookYearException, NullBookAuthorException, NullBookTitleException, InvalidBookTitleException {
        return dao.newBook(book);
    }


    public void deleteBook(Integer bookId) throws InvalidBookIdException, NullBookIdException {
        dao.deleteBook(bookId);
    }

    public Book editBook(Integer bookId, Book updatedBook) throws InvalidBookIdException, NullBookIdException, InvalidBookAuthorsException, InvalidBookTitleException, InvalidBookYearException, NullBookAuthorException, NullBookTitleException {
        return dao.editBook(bookId, updatedBook);
    }


}
