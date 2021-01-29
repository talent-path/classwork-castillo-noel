package com.tp.library.persistence;

import com.tp.library.exceptions.InvalidBookIdException;
import com.tp.library.exceptions.NullBookIdException;
import com.tp.library.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibraryInMemDAO implements LibraryDAO {
    List<Book> allBooks = new ArrayList<>();
    Integer id = 0;

    @Override
    public Book getBookById(Integer bookId) throws InvalidBookIdException, NullBookIdException {

        if (bookId == null) {
            throw new NullBookIdException("You cannot retrieve a Book with null id.");
        }

        for (Book book : allBooks) {
            if (book.getBookId().equals(bookId)) {

                return book;
            }
        }
        throw new InvalidBookIdException("No Book with " + bookId);
    }

    @Override
    public List<Book> getAllBooks() {

        List<Book> copyAllBooks = new ArrayList<>();
        for (Book copy : allBooks) {
            copyAllBooks.add(new Book(copy));
        }

        return copyAllBooks;
    }

    @Override
    public void deleteBook(Integer bookId) throws InvalidBookIdException {
        for (int i = 0; i < allBooks.size(); i++) {
            if (allBooks.get(i).getBookId().equals(bookId)) {
                allBooks.remove(i);
                return;
            }
        }
        throw new InvalidBookIdException("Cannot delete Book with id " + bookId);
    }

    @Override
    public Book newBook(Book book) {


        return book;
    }

    @Override
    public Book editBook(Book currentBook, Book updatedBook) {

        return updatedBook;
    }


}



