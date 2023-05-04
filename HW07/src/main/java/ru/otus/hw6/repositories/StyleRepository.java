package ru.otus.hw6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw6.domain.Style;

import java.util.List;
import java.util.Optional;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {
    long count();

    Optional<Style> findById(Long id);

    Style save(Style style);


    void deleteById(Long id);

    List<Style> findAll();
}
