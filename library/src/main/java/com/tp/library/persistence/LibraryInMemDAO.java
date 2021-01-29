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
        if (bookId == null) {
            throw new NullBookIdException("You cannot retrieve a Book with null id.");
        }
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
    public List<Book> getAllBooksByTitle(String title) throws NullBookTitleException {
        if (title == null) {
            throw new NullBookTitleException("Cannot retrieve books with a null value for title.");
        }
        List<Book> copyAllBooks = new ArrayList<>();
        for (Book copy : allBooks) {
            if (copy.getTitle().toLowerCase().contains(title.toLowerCase())) {
                copyAllBooks.add(new Book(copy));
            }
        }
        return copyAllBooks;
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) throws NullBookAuthorException {
        if (author == null) {
            throw new NullBookAuthorException("Cannot retrieve books with a null value for author.");
        }
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
    public List<Book> getAllBooksByYear(Integer year) throws NullBookYearException {
        if (year == null) {
            throw new NullBookYearException("Cannot retrieve books with a null value for publication year.");
        }
        List<Book> copyAllBooks = new ArrayList<>();
        for (Book copy : allBooks) {
            if (copy.getPublicationYear().equals(year)) {
                copyAllBooks.add(new Book(copy));
            }
        }
        return copyAllBooks;
    }

    @Override
    public void deleteBook(Integer bookId) throws InvalidBookIdException, NullBookIdException {
        if (bookId == null) {
            throw new NullBookIdException("You cannot delete a Book with null id.");
        }
        for (int i = 0; i < allBooks.size(); i++) {
            if (allBooks.get(i).getId().equals(bookId)) {
                allBooks.remove(i);
                return;
            }
        }
        throw new InvalidBookIdException("Cannot delete Book with id " + bookId);
    }

    @Override
    public Book newBook(Book book) throws NullBookIdException, InvalidBookAuthorsException, InvalidBookYearException, NullBookAuthorException, NullBookTitleException, InvalidBookTitleException {
        if (book.getId() == null) {
            throw new NullBookIdException("You cannot add a Book with null id.");
        }
        if(book.getTitle() == null){
            throw new NullBookTitleException("You cannot add a Book with null title.");
        }
        if(book.getTitle().equals("")){
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
        if(book.getPublicationYear() > Calendar.getInstance().get(Calendar.YEAR)
        || book.getPublicationYear() < 800){
            throw new InvalidBookYearException("No books were published during the year submitted!");
        }
        allBooks.add(book);
        return book;
    }

    @Override
    public Book editBook(Integer bookId, Book updatedBook) throws InvalidBookIdException, NullBookIdException, InvalidBookAuthorsException, NullBookTitleException, InvalidBookYearException, NullBookAuthorException, InvalidBookTitleException {

        if(updatedBook.getTitle() == null){
            throw new NullBookTitleException("You cannot edit a Book to have a null title.");
        }
        if(updatedBook.getTitle().equals("")){
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
        if(updatedBook.getPublicationYear() > Calendar.getInstance().get(Calendar.YEAR)
                || updatedBook.getPublicationYear() < 800){
            throw new InvalidBookYearException("No books were published during the year submitted!");
        }
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



