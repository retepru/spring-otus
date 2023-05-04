package ru.otus.hw6.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw6.domain.Author;
import ru.otus.hw6.domain.Book;
import ru.otus.hw6.domain.Style;
import ru.otus.hw6.dto.BookDto;
import ru.otus.hw6.exception.NotFoundException;
import ru.otus.hw6.repositories.AuthorRepository;
import ru.otus.hw6.repositories.BookRepository;
import ru.otus.hw6.service.AuthorService;
import ru.otus.hw6.service.BookService;
import ru.otus.hw6.service.StyleService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BookController {
    private BookService bookService;
    private AuthorService authorService;
    private StyleService styleService;

    public BookController(BookService bookService, AuthorService authorService, StyleService styleService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.styleService = styleService;
    }

    @GetMapping("/book")
    public List<Book> listPage() {
        return commentToNull(bookService.findAll());
    }

    @PostMapping("/book/{id}")
    @ResponseBody
    public Book update(@RequestBody Book book) { // todo будет ли правильно этот код перенести в сервис?
        Book bookDB = bookService.getById(book.getId()).orElseThrow(NotFoundException::new);

        bookDB.setName(book.getName());

        if (bookDB.getAuthor().getId() != book.getAuthor().getId()) {
            Author author = authorService.getById(book.getAuthor().getId()).orElseThrow(NotFoundException::new);
            bookDB.setAuthor(author);
        }

        if (bookDB.getStyle().getId() != book.getStyle().getId()) {
            Style style = styleService.getById(book.getStyle().getId()).orElseThrow(NotFoundException::new);
            bookDB.setStyle(style);
        }
        return bookService.save(bookDB);
    }
    @DeleteMapping("/book/{id}")
    public List<Book> deleteMap(@PathVariable long id ) {
        bookService.deleteById(id);
        return commentToNull(bookService.findAll());
    }

    @GetMapping("/book/{id}/delete")
    public String delete(@PathVariable long id ) {
        bookService.deleteById(id);
        return "redirect:/book";
    }

    @GetMapping("/book/{id}")
    public String editPage(@PathVariable String id, Model model) {
        // добавить утилиту для преобразования id в long
        Book book = bookService.getById(Long.parseLong(id)).orElseThrow(NotFoundException::new);

        model.addAttribute("bookDto", BookDto.bookToBookDto(book));
        model.addAttribute("authors", authorService.getAll());
        model.addAttribute("styles", styleService.getAll());
        return "book/edit";
    }

    private static List<Book> commentToNull(List<Book> books) {
        return books.stream().peek(book -> book.setComments(null)).collect(Collectors.toList());
    }
}

