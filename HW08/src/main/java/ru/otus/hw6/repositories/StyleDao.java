package ru.otus.hw6.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw6.domain.Author;
import ru.otus.hw6.domain.Style;

import java.util.List;
import java.util.Optional;

public interface StyleDao extends MongoRepository<Style, Long> {
//    long count();
//
//    Optional<Style> findById(long id);
//
//    Style save(Style style);
//
//
//    void deleteById(long id);
//
//    List<Style> getAll();
}
