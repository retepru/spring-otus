package ru.otus.hw6.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw6.domain.Author;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    long count();

    Optional<Author> findById(Long id);

    Author save(Author author);

    void deleteById(Long id);

    List<Author> findAll();
}
