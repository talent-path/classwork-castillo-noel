package com.tp.library.services;


import com.tp.library.exceptions.*;
import com.tp.library.model.Book;
import com.tp.library.persistence.LibraryInMemDAO;
import com.tp.library.service.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryServiceTests {

    @Autowired
    LibraryService toTest;


    //this will run before each @Test method
    @BeforeEach
    public void setup() {
        try {
            List<Book> allBooks = toTest.getAllBooks();

            for (Book toRemove : allBooks) {
                toTest.deleteBook(toRemove.getId());
            }

            List<String> authors = new ArrayList<>();
            authors.add("Author One");
            authors.add("Author Two");
            Book testBook = new Book(0, "My First Book", authors, 2020);
            toTest.newBook(testBook);

            authors = new ArrayList<>();
            authors.add("Author Three");
            testBook = new Book(1, "My Second Book", authors, 2021);
            toTest.newBook(testBook);
        } catch (InvalidBookIdException | NullBookIdException | InvalidBookAuthorsException
                | InvalidBookYearException | NullBookAuthorException | NullBookTitleException
                | InvalidBookTitleException e) {
            fail();
        }
    }


    //READING A BOOK TESTS
    @Test
    public void getBookTestGoldenPath() {
        try {
            Book testBook = toTest.getBookById(0);
            assertTrue(testBook.getTitle().equals("My First Book"));
            assertEquals(0, testBook.getId());
            assertEquals(2, testBook.getAuthors().size());
            assertEquals(2020, testBook.getPublicationYear());
        } catch (InvalidBookIdException | NullBookIdException e) {
            System.out.println(e);
            fail();
        }

    }

    @Test
    public void getAllBooksByTitleTestGoldenPath() {
        try {
            assertEquals(1, toTest.getAllBooksByTitle("FiRst").size());
            assertEquals(0, toTest.getAllBooksByTitle("firsT").get(0).getId());

        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void getAllBooksByAuthorTestGoldenPath() {
        try {
            assertEquals(2, toTest.getAllBooksByAuthor("author").size());
            assertEquals(1, toTest.getAllBooksByAuthor("one").size());

        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }

    @Test
    public void getAllBooksByYearTestGoldenPath() {
        try {
            assertEquals(1, toTest.getAllBooksByYear(2020).size());
            assertEquals(1, toTest.getAllBooksByYear(2021).get(0).getId());

        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }


    @Test
    public void getBookByIdTestNullBookId() {
        try {
            Book testBook = toTest.getBookById(null);
            fail();
        } catch (InvalidBookIdException e) {
            fail();

        } catch (NullBookIdException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void getAllBooksByTitleTestNullTitle() {
        try {
            List<Book> testBooks = toTest.getAllBooksByTitle(null);
            fail();
        } catch (NullBookTitleException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void getAllBooksByAuthorTestNullAuthor() {
        try {
            List<Book> testBooks = toTest.getAllBooksByAuthor(null);
            fail();
        } catch (NullBookAuthorException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void getAllBooksByYearTestNullYear() {
        try {
            List<Book> testBooks = toTest.getAllBooksByYear(null);
            fail();
        } catch(InvalidBookYearException e) {
            fail();
        } catch (NullBookYearException  ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void getBookByIdTestPastUpperBoundBookId() {
        try {
            Book testBook = toTest.getBookById(Integer.MAX_VALUE);
        } catch (NullBookIdException e) {
            fail();

        } catch (InvalidBookIdException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void getBookByIdTestPastLowerBoundBookId() {
        try {
            Book testBook = toTest.getBookById(Integer.MIN_VALUE);
        } catch (NullBookIdException e) {
            fail();

        } catch (InvalidBookIdException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    //CREATING A BOOK TESTS
    @Test
    public void addBookTestPastUpperBoundPubYear() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Author Four");
            Book testBook = new Book(3, "A Third Book", authors, Integer.MAX_VALUE);
            toTest.newBook(testBook);
        } catch (NullBookIdException | InvalidBookAuthorsException | NullBookAuthorException
                | NullBookTitleException | InvalidBookTitleException e) {
            fail();
        } catch (InvalidBookYearException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void addBookTestPastLowerBoundPubYear() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Author Four");
            Book testBook = new Book(3, "A Third Book", authors, Integer.MIN_VALUE);
            toTest.newBook(testBook);
        } catch (NullBookIdException | InvalidBookAuthorsException | NullBookAuthorException
                | NullBookTitleException | InvalidBookTitleException e) {
            fail();
        } catch (InvalidBookYearException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void addBookTestNullBookAuthor() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add(null);
            Book testBook = new Book(3, "A Third Book", authors, 2021);
            toTest.newBook(testBook);
        } catch (NullBookIdException | InvalidBookYearException | InvalidBookAuthorsException
                | NullBookTitleException | InvalidBookTitleException e) {
            fail();
        } catch (NullBookAuthorException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void addBookTestEmptyBookAuthor() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("");
            Book testBook = new Book(3, "A Third Book", authors, 2021);
            toTest.newBook(testBook);
        } catch (NullBookIdException | InvalidBookYearException | NullBookAuthorException
                | NullBookTitleException | InvalidBookTitleException e) {
            fail();
        } catch (InvalidBookAuthorsException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void addBookTestNullBookTitle() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Author Four");
            Book testBook = new Book(3, null, authors, 2021);
            toTest.newBook(testBook);
        } catch (NullBookIdException | InvalidBookYearException | InvalidBookAuthorsException
                | NullBookAuthorException | InvalidBookTitleException e) {
            fail();
        } catch (NullBookTitleException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void addBookTestEmptyBookTitle() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Author Four");
            Book testBook = new Book(3, "", authors, 2021);
            toTest.newBook(testBook);
        } catch (NullBookIdException | InvalidBookYearException | InvalidBookAuthorsException
                | NullBookAuthorException | NullBookTitleException e) {
            fail();
        } catch (InvalidBookTitleException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    //EDITING A BOOK TESTS
    @Test
    public void editBookTestPastUpperBoundPubYear() {
        try {
            Book testBook = toTest.getBookById(0);
            testBook.setPublicationYear(Integer.MAX_VALUE);
            toTest.editBook(0, testBook);

        } catch (NullBookIdException | InvalidBookAuthorsException | NullBookAuthorException
                | NullBookTitleException | InvalidBookTitleException | InvalidBookIdException e) {
            fail();
        } catch (InvalidBookYearException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void editBookTestPastLowerBoundPubYear() {
        try {
            Book testBook = toTest.getBookById(0);
            testBook.setPublicationYear(Integer.MIN_VALUE);
            toTest.editBook(0, testBook);

        } catch (NullBookIdException | InvalidBookAuthorsException | NullBookAuthorException
                | NullBookTitleException | InvalidBookTitleException | InvalidBookIdException e) {
            fail();
        } catch (InvalidBookYearException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void editBookTestNullBookAuthor() {
        try {
            Book testBook = toTest.getBookById(0);
            testBook.addAuthor(null);
            toTest.editBook(0, testBook);

        } catch (NullBookIdException | InvalidBookYearException | InvalidBookAuthorsException
                | NullBookTitleException | InvalidBookTitleException | InvalidBookIdException e) {
            fail();
        } catch (NullBookAuthorException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void editBookTestEmptyBookAuthor() {
        try {
            Book testBook = toTest.getBookById(0);
            testBook.addAuthor("");
            toTest.editBook(0, testBook);

        } catch (NullBookIdException | InvalidBookYearException | NullBookAuthorException
                | NullBookTitleException | InvalidBookTitleException | InvalidBookIdException e) {
            fail();
        } catch (InvalidBookAuthorsException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void editBookTestNullBookTitle() {
        try {
            Book testBook = toTest.getBookById(0);
            testBook.setTitle(null);
            toTest.editBook(0, testBook);

        } catch (NullBookIdException | InvalidBookYearException | InvalidBookAuthorsException
                | NullBookAuthorException | InvalidBookTitleException | InvalidBookIdException e) {
            fail();
        } catch (NullBookTitleException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void editBookTestEmptyBookTitle() {
        try {
            Book testBook = toTest.getBookById(0);
            testBook.setTitle("");
            toTest.editBook(0, testBook);

        } catch (NullBookIdException | InvalidBookYearException | InvalidBookAuthorsException
                | NullBookAuthorException | NullBookTitleException | InvalidBookIdException e) {
            fail();
        } catch (InvalidBookTitleException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }


}
