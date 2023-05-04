package ru.otus.hw6.dao;


import ru.otus.hw6.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    long count();

    Optional<Author> getById(long id);

    void insert(Author book);

    void update(Author book); // возможно совмещен с insert

    void deleteById(long id);

    List<Author> getAll();
}
