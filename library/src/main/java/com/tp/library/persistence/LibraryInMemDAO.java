package com.tp.library.persistence;

import com.tp.library.exceptions.*;
import com.tp.library.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository
public class LibraryInMemDAO implements LibraryDAO {
    List<Book> allBooks = new ArrayList<>();
    Integer id = 0;

    @Override
    public Book getBookById(Integer bookId) throws InvalidBookIdException, NullBookIdException {
        for (Book book : allBooks) {
            if (book.getId().equals(bookId)) {
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
    public List<Book> getAllBooksByTitle(String title)  {

        List<Book> copyAllBooks = new ArrayList<>();
        for (Book copy : allBooks) {
            if (copy.getTitle().toLowerCase().contains(title.toLowerCase())) {
                copyAllBooks.add(new Book(copy));
            }
        }
        return copyAllBooks;
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author)  {

        List<Book> copyAllBooks = new ArrayList<>();
        for (Book copy : allBooks) {
            for (String authorToCheck : copy.getAuthors()) {
                if (authorToCheck.toLowerCase().contains(author.toLowerCase())) {
                    copyAllBooks.add(new Book(copy));
                    break;
                }
            }
        }
        return copyAllBooks;
    }

    @Override
    public List<Book> getAllBooksByYear(Integer year)  {
        List<Book> copyAllBooks = new ArrayList<>();
        for (Book copy : allBooks) {
            if (copy.getPublicationYear().equals(year)) {
                copyAllBooks.add(new Book(copy));
            }
        }
        return copyAllBooks;
    }

    @Override
    public void deleteBook(Integer bookId) throws InvalidBookIdException {
        for (int i = 0; i < allBooks.size(); i++) {
            if (allBooks.get(i).getId().equals(bookId)) {
                allBooks.remove(i);
                return;
            }
        }
        throw new InvalidBookIdException("Cannot delete Book with id " + bookId);
    }

    @Override
    public Book newBook(Book book) {
        allBooks.add(book);
        return book;
    }

    @Override
    public Book editBook(Integer bookId, Book updatedBook) throws InvalidBookIdException {
        for (Book book : allBooks) {
            if (book.getId().equals(bookId)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthors(updatedBook.getAuthors());
                book.setPublicationYear(updatedBook.getPublicationYear());
                return book;
            }
        }
        throw new InvalidBookIdException("No Book with " + bookId);
    }
}



