package com.tp.library.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;


public class Book {

    // V A R I A B L E S
    private Integer bookId;
    private String title;
    private List<String> authors;
    private Integer publicationYear;


    // C O N S T R U C T O R S
    public Book(Integer bookId, String title, List<String> authors, Integer publicationYear) {
        this.bookId = bookId;
        this.title = title;
        this.authors = authors;
        this.publicationYear = publicationYear;
    }

    public Book(Book that) {
        this.bookId = that.bookId;
        this.title = that.title;
        this.authors = that.authors;
        this.publicationYear = that.publicationYear;

    }

    // G E T T E R S && S E T T E R S
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

}
