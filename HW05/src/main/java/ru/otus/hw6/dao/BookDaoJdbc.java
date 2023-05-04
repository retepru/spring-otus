package ru.otus.hw6.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.hw6.domain.Author;
import ru.otus.hw6.domain.Book;
import ru.otus.hw6.domain.Style;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class BookDaoJdbc implements BookDao {
    private final NamedParameterJdbcTemplate namedParameter;

    private final AuthorDao authorDao;
    private final StyleDao styleDao;

    public BookDaoJdbc(NamedParameterJdbcTemplate namedParameter, AuthorDao authorDao, StyleDao styleDao) {
        this.namedParameter = namedParameter;
        this.authorDao = authorDao;
        this.styleDao = styleDao;
    }

    @Override
    public long count() {
        return namedParameter.queryForObject(
                "select count(id) from books",
                new HashMap<String, Object>(),
                Long.class
        );
    }

    @Override
    public Optional<Book> getById(long id) {
        Optional<Book> book = namedParameter.query(
                "select b.id, b.name, a.id as id_author, a.name as author, s.id as id_style, s.name as style from books AS b " +
                        "LEFT JOIN AUTHORS as a ON a.ID  = b.id_author " +
                        "LEFT JOIN STYLES as s ON s.ID  = b.id_style " +
                        "WHERE b.id= :id",
                Collections.singletonMap("id", id),
                new BookResultSet());
        return book;
    }

    @Override
    public void insert(Book book) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", book.getName());
        params.put("id_author", book.getAuthor().getId());
        params.put("id_style", book.getStyle().getId());

        namedParameter.update(
                "insert into books (name, id_author, id_style) values (:name, :id_author, :id_style)",
                params);
    }

    @Override
    public void update(Book book) { // todo надо обновление отдельных полей
        Map<String, Object> params = new HashMap<>();
        params.put("id", book.getId());
        params.put("name", book.getName());
        params.put("id_author", book.getAuthor().getId());
        params.put("id_style", book.getStyle().getId());
        namedParameter.update(
                "update books set name = :name, id_author = :id_author, id_style = :id_style where id = :id",
                params);
    }

    @Override
    public void deleteById(long id) {
        namedParameter.update(
                "delete from books where id = :id",
                Collections.singletonMap("id", id)
        );
    }

    @Override
    public List<Book> getAll() {
        return namedParameter.query(
                "select b.id, b.name, a.id as id_author, a.name as author, s.id as id_style, s.name as style from books AS b " +
                        "LEFT JOIN AUTHORS as a ON a.ID  = b.id_author " +
                        "LEFT JOIN STYLES as s ON s.ID  = b.id_style",
                Collections.emptyMap(),
                new BookMapper()
        );
    }

    private static class BookMapper implements RowMapper<Book> { // есть класс, который делает всё сам.

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book(rs.getLong("id"), rs.getString("name"));
            Author author = rs.getLong("id_author") == 0 ? null : new Author(rs.getLong("id_author"), rs.getString("author"));
            Style style = rs.getLong("id_style") == 0 ? null : new Style(rs.getLong("id_style"), rs.getString("style"));
            book.setAuthor(author);
            book.setStyle(style);
            return book;
        }
    }

    private static class BookResultSet implements ResultSetExtractor<Optional<Book>> {

        @Override
        public Optional<Book> extractData(ResultSet rs) throws SQLException, DataAccessException {
            if (rs.next()) {
                BookDaoJdbc.BookMapper book = new BookDaoJdbc.BookMapper();
                return Optional.of(book.mapRow(rs, 0));
            }
            else {
                return Optional.empty();
            }
        }
    }
}
