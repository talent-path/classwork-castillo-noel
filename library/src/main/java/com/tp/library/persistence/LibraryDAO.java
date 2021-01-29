package com.tp.library.persistence;

import com.tp.library.exceptions.*;
import com.tp.library.model.Book;

import java.util.List;

public interface LibraryDAO {

    Book getBookById(Integer BookId) throws InvalidBookIdException;

    List<Book> getAllBooks();

    List<Book> getAllBooksByTitle(String title);

    List<Book> getAllBooksByAuthor(String author);

    List<Book> getAllBooksByYear(Integer year);

    void deleteBook(Integer BookId) throws InvalidBookIdException;

    Book newBook(Book book);

    Book editBook(Integer bookId, Book updatedBook) throws InvalidBookIdException;

}
