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
        } catch (InvalidBookIdException e) {
            fail();
        }
    }

    @Test
    public void getBookTestGoldenPath() {
        try {
            Book testBook = toTest.getBookById(0);
            assertTrue(testBook.getTitle().equals("My First Book"));
            assertEquals(0, testBook.getId());
            assertEquals(2, testBook.getAuthors().size());
            assertEquals(2020, testBook.getPublicationYear());
        } catch (InvalidBookIdException e) {
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
    public void getBookByIdTestPastUpperBoundBookId() {
        try {
            Book testBook = toTest.getBookById(Integer.MAX_VALUE);
        } catch (InvalidBookIdException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void getBookByIdTestPastLowerBoundBookId() {
        try {
            Book testBook = toTest.getBookById(Integer.MIN_VALUE);
        } catch (InvalidBookIdException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }


    @Test
    public void addBookTestGoldenPath() {
        try {
            List<String> authors = new ArrayList<>();
            authors.add("Author Four");
            Book testBook = new Book(3, "A Third Book", authors, 2021);
            toTest.newBook(testBook);
            assertEquals("A Third Book", toTest.getBookById(3).getTitle());
            assertEquals("Author Four", toTest.getBookById(3).getAuthors().get(0));
            assertEquals(2021, toTest.getBookById(3).getPublicationYear());

        } catch (InvalidBookIdException e) {
            fail();
        }
    }


    @Test
    public void editBookTestPastGoldenPath() {
        try {
            Book testBook = toTest.getBookById(0);
            testBook.setTitle("My First Book Updated");
            testBook.setPublicationYear(2021);
            toTest.editBook(0, testBook);
            assertEquals("My First Book Updated", toTest.getBookById(0).getTitle());
            assertEquals("Author One", toTest.getBookById(0).getAuthors().get(0));
            assertEquals("Author Two", toTest.getBookById(0).getAuthors().get(1));
            assertEquals(2021, toTest.getBookById(0).getPublicationYear());
        } catch (InvalidBookIdException e) {
            fail();
        }

    }
}
