package ru.otus.hw6.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.hw6.domain.Author;
import ru.otus.hw6.service.AuthorService;

import java.util.List;

@ShellComponent
public class AuthorsCommands {

    private AuthorService authorService;

    public AuthorsCommands(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ShellMethod(value = "Получение автора по id", key = {"a id", "author getById"})
    public String getAuthorById(@ShellOption({"id"}) String id) {
        return authorService.getById(id);
    }

    @ShellMethod(value = "Удалить автора по id", key = {"a del", "author delete"})
    public void deleteAuthorById(@ShellOption({"id"}) String id) {
        authorService.deleteById(id);
    }

    @ShellMethod(value = "Создать автора", key = {"a cre", "author create"})
    public void createAuthor(@ShellOption({"name"}) String name) {
        Author author = new Author();
        author.setName(name);
        authorService.create(author);
    }

    @ShellMethod(value = "Обновить автора", key = {"a up", "author update"})
    public void update(@ShellOption({"id", "name"}) String id, String name) {
        Author author = new Author();
        author.setName(name);
        author.setId(id);
        authorService.update(author);
    }

    @ShellMethod(value = "Количество авторов", key= {"a count", "author count"})
    public void count() {
        authorService.count();
    }
    @ShellMethod(value = "Вывести всех авторов", key = {"a", "author"})
    public void getAllAuthor() {
        List<Author> authors = authorService.getAll();

        if (authors.isEmpty()) {
            System.out.println("Авторов нет");
        }
        else {
            authors.forEach(author -> System.out.println(author));
        }
    }
}
