package ru.otus.hw6.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw6.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao extends MongoRepository<Author, String> {
//    long count();
//
//    Optional<Author> findById(long id);
//
//    Author save(Author author);
//
//    void insert(Author book);
//
//    void update(Author book); // возможно совмещен с insert
//
//    void deleteById(long id);
//
//    List<Author> getAll();
}
