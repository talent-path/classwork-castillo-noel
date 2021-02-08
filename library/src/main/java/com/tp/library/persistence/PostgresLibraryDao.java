package com.tp.library.persistence;

import com.tp.library.exceptions.InvalidBookIdException;
import com.tp.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostgresLibraryDao implements LibraryDAO {


    @Autowired
    JdbcTemplate template;

    @Override
    public Book getBookById(Integer BookId) throws InvalidBookIdException {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public List<Book> getAllBooksByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return null;
    }

    @Override
    public List<Book> getAllBooksByYear(Integer year) {
        return null;
    }

    @Override
    public void deleteBook(Integer BookId) throws InvalidBookIdException {

    }

    @Override
    public Book newBook(Book book) {

        List<Integer> authorList = new ArrayList<>();

        for (String author : book.getAuthors()) {
            Integer authorId = addOrRetrieve(author);
            authorList.add(authorId);
        }
        return null;
    }

    private Integer addOrRetrieve(String author) {

        Integer authorId = getAuthorId(author);

        if (authorId == null) {
            authorId = addAuthor(author);
        }

        return authorId;
    }

    private Integer getAuthorId(String author) {

        List<Integer> id = template.query("SELECT id, name\n" +
                "\tFROM public.\"Author\"\n" +
                "\t\tWHERE \"name\" = '" + author + "';", new IdMapper());

        if(id.isEmpty()){
            return null;
        }

        return id.get(0);
    }

    @Override
    public Book editBook(Integer bookId, Book updatedBook) throws InvalidBookIdException {
        return null;
    }

    private Integer addAuthor(String author) {

        return template.query("INSERT INTO public.\"Author\"(name)\n" +
                        "\tVALUES ('" + author + "')\n" +
                        "\t\tRETURNING \"id\";",
                new IdMapper()).get(0);
    }

    private class IdMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("id");
        }
    }
}
