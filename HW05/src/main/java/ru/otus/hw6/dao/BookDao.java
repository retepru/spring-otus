package ru.otus.hw6.dao;

import ru.otus.hw6.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    long count();

    Optional<Book> getById(long id);

    void insert(Book book);

    void update(Book book); // возможно совмещен с insert

    void deleteById(long id);

    List<Book> getAll();
}
