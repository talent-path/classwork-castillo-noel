package com.tp.library.persistence;


import com.tp.library.exceptions.InvalidBookIdException;
import com.tp.library.exceptions.NullBookIdException;
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
    public void setup() throws InvalidBookIdException {
        List<Book> allBooks = toTest.getAllBooks();

        for (Book toRemove : allBooks) {
            toTest.deleteBook(toRemove.getId());
        }

        List<String> authors = new ArrayList<>();
        authors.add("Author One");
        authors.add("Author Two");
        Book testBook = new Book(0, "My First Book", authors, 2021);
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
    public void getGameByIdTestPastUpperBoundGameId() {
        try {
            Book testBook = toTest.getBookById(Integer.MAX_VALUE);
        } catch (NullBookIdException e) {
            fail();

        } catch (InvalidBookIdException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }

    @Test
    public void getBookByIdTestPastLowerBoundGameId() {
        try {
            Book testBook = toTest.getBookById(Integer.MIN_VALUE);
        } catch (NullBookIdException e) {
            fail();

        } catch (InvalidBookIdException ex) {
            //do nothing because this is the specific exception we WANT
        }
    }


}
