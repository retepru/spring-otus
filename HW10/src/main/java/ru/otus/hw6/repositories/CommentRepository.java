package ru.otus.hw6.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.otus.hw6.domain.Book;
import ru.otus.hw6.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Override
    Comment save(Comment comment);

    @Override
    Optional<Comment> findById(Long aLong);
    @Override
    List<Comment> findAll();

    @Override
    long count();

    @Override
    void deleteById(Long aLong);
}
