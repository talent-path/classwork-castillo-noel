package com.tp.library.persistence;


import com.tp.library.exceptions.*;
import com.tp.library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryInMemDAOTests {

    @Autowired
    LibraryInMemDAO toTest;


    //this will run before each @Test method
    @BeforeEach
    public void setup() throws InvalidBookIdException, NullBookIdException {
        List<Book> allBooks = toTest.getAllBooks();

        for (Book toRemove : allBooks) {
            toTest.deleteBook(toRemove.getId());
        }

        List<String> authors = new ArrayList<>();
        authors.add("Author One");
        authors.add("Author Two");
        Book testBook = new Book(0, "My First Book", authors, 2021);
        toTest.newBook(testBook);

        authors = new ArrayList<>();
        authors.add("Author Three");
        testBook = new Book(1, "My Second Book", authors, 2022);
        toTest.newBook(testBook);
    }


    @Test
    public void getBookTestGoldenPath() {
        try {
            Book testBook = toTest.getBookById(0);
            assertTrue(testBook.getTitle().equals("My First Book"));
            assertEquals(0, testBook.getId());
            assertEquals(2, testBook.getAuthors().size());
            assertEquals(2021, testBook.getPublicationYear());


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
            assertEquals(1, toTest.getAllBooksByYear(2021).size());
            assertEquals(0, toTest.getAllBooksByYear(2021).get(0).getId());

        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }


    @Test
    public void getBookByIdTestNullGameId() {
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
        } catch (NullBookYearException ex) {
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


}
