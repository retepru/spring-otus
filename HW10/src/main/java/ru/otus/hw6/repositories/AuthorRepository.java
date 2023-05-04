package ru.otus.hw6.repositories;


import org.springframework.data.repository.CrudRepository;
import ru.otus.hw6.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    @Override
    long count();
    @Override
    Optional<Author> findById(Long id);

    @Override
    <S extends Author> S save(S author);

    @Override
    void deleteById(Long id);

    @Override
    List<Author> findAll();
}
