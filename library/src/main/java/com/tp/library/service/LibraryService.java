package com.tp.library.service;


import com.tp.library.exceptions.*;
import com.tp.library.model.Book;
import com.tp.library.persistence.LibraryInMemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class LibraryService {

    @Autowired
    LibraryInMemDAO dao;

    public Book getBookById(Integer bookId) throws InvalidBookIdException, NullBookIdException {
        if (bookId == null) {
            throw new NullBookIdException("You cannot retrieve a Book with null id.");
        }
        return dao.getBookById(bookId);
    }

    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    public List<Book> getAllBooksByTitle(String title) throws NullBookTitleException {
        if (title == null) {
            throw new NullBookTitleException("Cannot retrieve books with a null value for title.");
        }
        return dao.getAllBooksByTitle(title);
    }

    public List<Book> getAllBooksByAuthor(String author) throws NullBookAuthorException {
        if (author == null) {
            throw new NullBookAuthorException("Cannot retrieve books with a null value for author.");
        }
        return dao.getAllBooksByAuthor(author);
    }

    public List<Book> getAllBooksByYear(Integer year) throws NullBookYearException {
        if (year == null) {
            throw new NullBookYearException("Cannot retrieve books with a null value for publication year.");
        }
        return dao.getAllBooksByYear(year);
    }

    public Book newBook(Book book) throws NullBookIdException, InvalidBookAuthorsException, InvalidBookYearException, NullBookAuthorException, NullBookTitleException, InvalidBookTitleException {

        if (book.getId() == null) {
            throw new NullBookIdException("You cannot add a Book with null id.");
        }
        if (book.getTitle() == null) {
            throw new NullBookTitleException("You cannot add a Book with null title.");
        }
        if (book.getTitle().equals("")) {
            throw new InvalidBookTitleException("You cannot add a Book with an empty title.");
        }
        if (book.getAuthors().size() == 0) {
            throw new InvalidBookAuthorsException("You cannot add a Book without authors.");
        }
        for (String authorToCheck : book.getAuthors()) {
            if (authorToCheck == null) {
                throw new NullBookAuthorException("You cannot add a Book with a null value for author.");
            }
            if (authorToCheck.equals("")) {
                throw new InvalidBookAuthorsException("You cannot add a Book without authors.");
            }
        }
        if (book.getPublicationYear() > Calendar.getInstance().get(Calendar.YEAR)
                || book.getPublicationYear() < 800) {
            throw new InvalidBookYearException("No books were published during the year submitted!");
        }
        return dao.newBook(book);
    }


    public void deleteBook(Integer bookId) throws InvalidBookIdException, NullBookIdException {
        if (bookId == null) {
            throw new NullBookIdException("You cannot delete a Book with null id.");
        }
        dao.deleteBook(bookId);
    }

    public Book editBook(Integer bookId, Book updatedBook) throws InvalidBookIdException, NullBookIdException, InvalidBookAuthorsException, InvalidBookTitleException, InvalidBookYearException, NullBookAuthorException, NullBookTitleException {
        if (updatedBook.getTitle() == null) {
            throw new NullBookTitleException("You cannot edit a Book to have a null title.");
        }
        if (updatedBook.getTitle().equals("")) {
            throw new InvalidBookTitleException("You cannot edit a Book to have no title.");
        }
        if (updatedBook.getAuthors().size() == 0) {
            throw new InvalidBookAuthorsException("You cannot edit a Book to have no authors.");
        }
        for (String authorToCheck : updatedBook.getAuthors()) {
            if (authorToCheck == null) {
                throw new NullBookAuthorException("You cannot edit a Book to have a null value for author.");
            }
            if (authorToCheck.equals("")) {
                throw new InvalidBookAuthorsException("You cannot edit a Book to have authors.");
            }
        }
        if (updatedBook.getPublicationYear() > Calendar.getInstance().get(Calendar.YEAR)
                || updatedBook.getPublicationYear() < 800) {
            throw new InvalidBookYearException("No books were published during the year submitted!");
        }
        return dao.editBook(bookId, updatedBook);
    }


}
