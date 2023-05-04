package ru.otus.hw6.service;

import org.springframework.stereotype.Service;
import ru.otus.hw6.repositories.AuthorRepository;
import ru.otus.hw6.repositories.BookRepository;
import ru.otus.hw6.repositories.StyleRepository;
import ru.otus.hw6.domain.Author;
import ru.otus.hw6.domain.Book;
import ru.otus.hw6.domain.Style;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final StyleRepository styleRepository;


    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, StyleRepository styleRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.styleRepository = styleRepository;
    }

    public long count() {
        return bookRepository.count();
    }

    public String getById(long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get().toString();
        }
        else {
            return "Книга не найдена";
        }
    }

    @Transactional
    public String create(String name, Long authorId, Long styleId) {
        Optional<Author> author = authorRepository.findById(authorId);
        StringBuilder message = new StringBuilder();
        if (author.isEmpty()) {
            message.append("Автора с таким id нет");
        }

        Optional<Style> style = styleRepository.findById(styleId);
        if (author.isEmpty()) {
            message.append("Жанра с таким id нет");
        }
        if (message.length() != 0) {
            return message.toString();
        }

        Book book = new Book(null, name, author.get(), style.get());
        bookRepository.save(book);

        return "Книга добавлена";
    }

    @Transactional
    public String update(Long id, String name, Long authorId, Long styleId) {

        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) {
            return "Книги с таким id нет";
        }

        Book book = optionalBook.get();
        if (book.getName().equals(name) && book.getAuthor().getId().equals(authorId) && book.getStyle().getId().equals(styleId)) {
            return "Аттрибуты те же, обновления не нужно";
        }

        StringBuilder message = new StringBuilder();
        if (!book.getAuthor().getId().equals(authorId)) {
            Optional<Author> optionalAuthor = authorRepository.findById(authorId);
            if (optionalAuthor.isEmpty()) {
                message.append("Автора с таким id нет");
            }
            else {
                book.setAuthor(optionalAuthor.get());
            }
        }

        if (!book.getStyle().getId().equals(styleId)) {
            Optional<Style> optionalStyle = styleRepository.findById(styleId);
            if (optionalStyle.isEmpty()) {
                message.append("Жанра с таким id нет");
            }
            else {
                book.setStyle(optionalStyle.get());
            }
        }

        if (message.length() != 0) {
            return message.toString();
        }

        book.setName(name);
        bookRepository.save(book);
        return "Книга обновлена";
    }
    @Transactional
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getAll() {
        List<Book> books = bookRepository.findAll();
        return bookRepository.findAll();
    }
}
