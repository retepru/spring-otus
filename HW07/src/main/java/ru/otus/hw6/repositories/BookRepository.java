package ru.otus.hw6.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw6.domain.Author;
import ru.otus.hw6.domain.Book;
import ru.otus.hw6.domain.Comment;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    long count();

    Book save(Book book);

    Optional<Book> findById(Long aLong);

    @EntityGraph(value = "book-author-style-entity-graph" , type= EntityGraph.EntityGraphType.FETCH)
    List<Book> findAll();

    void deleteById(Long aLong);
}
