package ru.otus.hw6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw6.domain.Author;
import ru.otus.hw6.domain.Comment;
import ru.otus.hw6.domain.Style;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findById(long id);

    Comment save(Comment comment);

    void deleteById(long id);

    List<Comment> findAll();
}
