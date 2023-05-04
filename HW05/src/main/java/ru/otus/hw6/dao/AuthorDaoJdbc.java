package ru.otus.hw6.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.hw6.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcTemplate namedParameter;

    public AuthorDaoJdbc(NamedParameterJdbcTemplate namedParameter) {
        this.namedParameter = namedParameter;
    }

    @Override
    public long count() {
        Map<String, Object> params = new HashMap<>();
        return namedParameter.queryForObject("select count(id) from authors", params, Long.class );
    }

    @Override
    public Optional<Author> getById(long id) {
        return namedParameter.
                query(
                        "select * from authors where id = :id", Collections.singletonMap("id", id), new AuthorResultSet()
                );
    }

    @Override
    public void insert(Author author) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", author.getName());
        // todo добавить параметры
        namedParameter.update(
        "insert into authors (name) values (:name)", params);
    }

    @Override
    public void update(Author author) {
        // todo что делаем если записи нет?
        Map<String, Object> params = new HashMap<>();
        params.put("id", author.getId());
        params.put("name", author.getName());
        namedParameter.update(
                "update authors SET name = :name where id = :id", params
        );
    }

    @Override
    public void deleteById(long id) {
        // вернёт 0 - если записи нет; вернёт номер id если запись была
        namedParameter.update(
                "delete from authors where id = :id", Collections.singletonMap("id", id));
    }

    @Override
    public List<Author> getAll() {
        List<Author> authors = namedParameter.query("select * from authors", Collections.singletonMap("", ""),  new AuthorMapper());
        return authors;
    }

    private static class AuthorMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            Author author = new Author();
            author.setId(rs.getLong("id"));
            author.setName(rs.getString("name"));
            return author;
        }
    }

    private static class AuthorResultSet implements ResultSetExtractor<Optional<Author>> {

        @Override
        public Optional<Author> extractData(ResultSet rs) throws SQLException, DataAccessException {
            if (rs.next()) {
                AuthorDaoJdbc.AuthorMapper authorMapper = new AuthorDaoJdbc.AuthorMapper();
                return Optional.of(authorMapper.mapRow(rs, 0));
            }
            else {
                return Optional.empty();
            }
        }
    }
}
