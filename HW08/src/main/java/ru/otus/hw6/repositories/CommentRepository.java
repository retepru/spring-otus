package ru.otus.hw6.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw6.domain.Author;
import ru.otus.hw6.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends MongoRepository<Comment, Long> {
    Optional<Comment> findById(long id);

    Comment save(Comment comment);

    void deleteById(long id);

    List<Comment> findAll();
}
