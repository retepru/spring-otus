package ru.otus.hw6.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.hw6.domain.Style;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class StyleDaoJdbc implements StyleDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public StyleDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public long count() {
        return 1;
    }

    @Override
    public Optional<Style> getById(long id) {
        return namedParameterJdbcTemplate.query(
                "select * from styles where id = :id",
                Collections.singletonMap("id", id),
                new StyleResultSet()
        );
    }

    @Override
    public void insert(Style style) {

    }

    @Override
    public void update(Style style) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<Style> getAll() {
        return namedParameterJdbcTemplate.query(
                "select * from styles"
                , new HashMap<String, String>(), new StyleMapper());
    }

    private static class StyleMapper implements RowMapper<Style> {

        @Override
        public Style mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Style(rs.getLong("id"), rs.getString("name"));
        }
    }

    private static class StyleResultSet implements ResultSetExtractor<Optional<Style>> {
        @Override
        public Optional<Style> extractData(ResultSet rs) throws SQLException, DataAccessException {
            if (rs.next()) {
                StyleDaoJdbc.StyleMapper styleMapper = new StyleDaoJdbc.StyleMapper();
                return Optional.of(styleMapper.mapRow(rs, 0));
            }
            else {
                return Optional.empty();
            }
        }
    }
}
