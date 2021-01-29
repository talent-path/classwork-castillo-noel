package com.tp.library.persistence;

import com.tp.library.exceptions.*;
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
    public Book newBook(Book book) throws NullBookIdException, InvalidBookAuthorsException {
        if (book.getId() == null) {
            throw new NullBookIdException("You cannot add a Book with null id.");
        }
        if (book.getAuthors().size() == 0) {
            throw new InvalidBookAuthorsException("You cannot add a Book without authors.");
        }

        for (String authorToCheck : book.getAuthors()) {
            if (authorToCheck.equals("")) {
                throw new InvalidBookAuthorsException("You cannot add a Book without authors.");
            }
        }

        allBooks.add(book);
        return book;
    }

    @Override
    public Book editBook(Integer bookId, Book updatedBook) throws InvalidBookIdException, NullBookIdException, InvalidBookAuthorsException {
        if (bookId == null) {
            throw new NullBookIdException("You cannot edit a Book with null id.");
        }
        for (Book book : allBooks) {
            if (book.getId().equals(bookId)) {
                if (!updatedBook.getTitle().equals("")) {
                    book.setTitle(updatedBook.getTitle());
                }
                if (updatedBook.getAuthors().size() != 0) {
                    Book copy = new Book(updatedBook);
                    for (String authorToCheck : updatedBook.getAuthors()) {
                        if (!authorToCheck.equals("")) {
                            copy.getAuthors().add(authorToCheck);
                        }
                    }
                    if (copy.getAuthors().size() == 0) {
                        throw new InvalidBookAuthorsException("You cannot edit a Book to have no authors.");
                    } else {
                        book.setAuthors(copy.getAuthors());
                    }
                }
                if (updatedBook.getPublicationYear() != null) {
                    book.setPublicationYear(updatedBook.getPublicationYear());
                }
                return book;
            }
        }
        throw new InvalidBookIdException("No Book with " + bookId);
    }
}



