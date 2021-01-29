package com.tp.library.persistence;

import com.tp.library.exceptions.*;
import com.tp.library.model.Book;

import java.util.List;

public interface LibraryDAO {

    Book getBookById(Integer BookId) throws InvalidBookIdException, NullBookIdException;

    List<Book> getAllBooks();

    List<Book> getAllBooksByTitle(String title) throws NullBookTitleException;

    List<Book> getAllBooksByAuthor(String author) throws NullBookAuthorException;

    List<Book> getAllBooksByYear(Integer year) throws NullBookYearException;

    void deleteBook(Integer BookId) throws InvalidBookIdException, NullBookIdException;

    Book newBook(Book book) throws NullBookIdException, InvalidBookAuthorsException;

    Book editBook(Integer bookId, Book updatedBook) throws InvalidBookIdException, NullBookIdException, InvalidBookAuthorsException;

}
