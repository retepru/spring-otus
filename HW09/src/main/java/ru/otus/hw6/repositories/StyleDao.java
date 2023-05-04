package ru.otus.hw6.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.otus.hw6.domain.Style;

import java.util.List;
import java.util.Optional;

public interface StyleDao extends CrudRepository<Style, Long> {
    @Override
    long count();

    @Override
    Style save(Style style);

    @Override
    Optional<Style> findById(Long id);

    @Override
    List<Style> findAll();
    @Override
    void deleteById(Long id);
}
