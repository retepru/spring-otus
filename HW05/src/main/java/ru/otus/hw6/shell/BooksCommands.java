package ru.otus.hw6.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.hw6.domain.Book;
import ru.otus.hw6.service.BookService;

import java.util.List;
import java.util.Optional;

@ShellComponent
public class BooksCommands {

    private final BookService bookService;

    public BooksCommands(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod(value = "Получить все книги", key = {"b", "book"})
    public void getAll() {
        List<Book> books = bookService.getAll();
        if(books.isEmpty()) {
            System.out.println("null");
        }
        else {
            books.forEach(book -> {
                System.out.println(book);
                System.out.println(book.getAuthor());
                System.out.println(book.getStyle());
            });
        }
    }

    @ShellMethod(value = "Удалить книгу", key = {"b del", "book delete"})
    public void delete(@ShellOption({"id"}) Long id) {
        bookService.deleteById(id);
    }

    @ShellMethod(value = "Создать книгу", key = {"b cre", "book create"})
    public void create(@ShellOption({"name", "authorId", "styleId"}) String name, Long authorId, Long styleId) {
        bookService.create(name, authorId, styleId); // todo где правильно сделать проверку?
    }

    @ShellMethod(value = "Обновить книгу", key = {"b u", "book update"})
    public void update(@ShellOption({"id", "name", "authorId", "styleId"}) Long id, String name, Long authorId, Long styleId) {
        bookService.update(id, name, authorId, styleId);
    }

    @ShellMethod(value = "Количество книг", key = {"b c", "book count"})
    public void count() {
        System.out.println(bookService.count());
    }

    @ShellMethod(value = "получит одну книгу", key = {"b id", "book getById"})
    public String getById(@ShellOption({"id"}) Long id) {
        return bookService.getById(id);
    }
}
