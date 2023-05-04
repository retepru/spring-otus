package ru.otus.hw6.service;

import org.springframework.stereotype.Service;
import ru.otus.hw6.domain.Book;
import ru.otus.hw6.domain.Comment;
import ru.otus.hw6.repositories.BookRepository;
import ru.otus.hw6.repositories.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    public CommentService(CommentRepository commentRepository, BookRepository bookRepository) {
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
    }

    public String getById(long id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()) {
            return commentOptional.get().toString();
        }

        return "Комментарий не найден";
    }

    public String create(String text, long bookId) {
        if (text == null || text.length() == 0) {
            return "Напишите комментарий";
        }

        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if (bookOptional.isEmpty()) {
            return "Такой книги нет";
        }

        Comment commentNew = new Comment(text);
        commentNew.setBook(bookOptional.get());

        commentRepository.save(commentNew);
        return "Комментарий добавлен";
    }

    public String update(Long id, String text) {

        if (text == null || text.length() == 0) {
            return "Текст комментария пуст";
        }

        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isEmpty()) {
            return "Такого комментария нет";
        }

        Comment comment = commentOptional.get();
        comment.setText(text);
        commentRepository.save(comment);

        return "Комментарий обновлён";
    }

    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }
}
