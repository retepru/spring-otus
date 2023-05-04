package ru.otus.hw6.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw6.domain.Book;

public interface BookRepository  extends MongoRepository<Book, Long> {
//    @Override
//    long count();
//
//    @Override
//    <S extends Book> S save(S entity);
//
//    @Override
//    Optional<Book> findById(Long aLong);
//
//    @EntityGraph(value = "book-author-style-entity-graph" , type= EntityGraph.EntityGraphType.FETCH)
//    @Override
//    List<Book> findAll();
//
//    @Override
//    void deleteById(Long aLong);
}
