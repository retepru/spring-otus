package ru.otus.hw6.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import ru.otus.hw6.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    long count();

    @Override
    <S extends Book> S save(S entity);

    @Override
    Optional<Book> findById(Long aLong);

    @EntityGraph(value = "book-author-style-entity-graph" , type= EntityGraph.EntityGraphType.FETCH)
    @Override
    List<Book> findAll();

    @Override
    void deleteById(Long aLong);
}
