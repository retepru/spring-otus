package ru.otus.hw6.service;

import org.springframework.stereotype.Service;
import ru.otus.hw6.dao.AuthorDao;
import ru.otus.hw6.dao.BookDao;
import ru.otus.hw6.dao.StyleDao;
import ru.otus.hw6.domain.Author;
import ru.otus.hw6.domain.Book;
import ru.otus.hw6.domain.Style;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final StyleDao styleDao;

    public BookService(BookDao bookDao, AuthorDao authorDao, StyleDao styleDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.styleDao = styleDao;
    }

    public long count() {
        return bookDao.count();
    }

    public String getById(long id) {
        Optional<Book> book = bookDao.getById(id);
        if (book.isPresent()) {
            return book.get().toString(); // todo добавить стиль и автора
        }
        else {
            return "Книга не найдена";
        }
    }

    public String create(String name, Long authorId, Long styleId) {
        Optional<Author> author = authorDao.getById(authorId);
        StringBuilder message = new StringBuilder();
        if (author.isEmpty()) {
            message.append("Автора с таким id нет");
        }

        Optional<Style> style = styleDao.getById(styleId);
        if (author.isEmpty()) {
            message.append("Жанра с таким id нет");
        }

        if (message.length() != 0) {
            return message.toString();
        }

        Book book = new Book(null, name, author.get(), style.get());
        bookDao.insert(book);

        return "Книга добавлена";
    }

    public String update(Long id, String name, Long authorId, Long styleId) {

        Optional<Book> optionalBook = bookDao.getById(id);
        if (optionalBook.isEmpty()) {
            return "Книги с таким id нет";
        }

        Book book = optionalBook.get();
        if (book.getName().equals(name) && book.getAuthor().getId().equals(authorId) && book.getStyle().getId().equals(styleId)) {
            return "Аттрибуты те же, обновления не нужно";
        }

        StringBuilder message = new StringBuilder();
        if (!book.getAuthor().getId().equals(authorId)) {
            Optional<Author> optionalAuthor = authorDao.getById(authorId);
            if (optionalAuthor.isEmpty()) {
                message.append("Автора с таким id нет");
            }
            else {
                book.setAuthor(optionalAuthor.get());
            }
        }

        if (!book.getStyle().getId().equals(styleId)) { // todo тут будут исключения если такого автора/ стиля нет
            Optional<Style> optionalStyle = styleDao.getById(styleId);
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
        bookDao.update(book);
        return "Книга обновлена";
    }

    public void deleteById(long id) {
        bookDao.deleteById(id);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
