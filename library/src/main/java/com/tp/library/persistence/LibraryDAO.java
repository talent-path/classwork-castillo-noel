package com.tp.library.persistence;

import com.tp.library.exceptions.InvalidBookIdException;
import com.tp.library.exceptions.NullBookIdException;
import com.tp.library.model.Book;

import java.util.List;

public interface LibraryDAO {

    Book getBookById(Integer BookId) throws InvalidBookIdException, NullBookIdException;

    List<Book> getAllBooks();

    void deleteBook(Integer BookId) throws InvalidBookIdException;

    Book newBook(Book book);

    Book editBook(Book currentBook, Book updatedBook);


}
