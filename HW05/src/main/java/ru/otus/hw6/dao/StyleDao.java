package ru.otus.hw6.dao;

import ru.otus.hw6.domain.Author;
import ru.otus.hw6.domain.Style;

import java.util.List;
import java.util.Optional;

public interface StyleDao {
    long count();

    Optional<Style> getById(long id);

    void insert(Style style);

    void update(Style style); // возможно совмещен с insert

    void deleteById(long id);

    List<Style> getAll();
}
