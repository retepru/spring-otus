package ru.otus.hw6.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.hw6.domain.Author;
import ru.otus.hw6.service.AuthorService;

import java.util.List;

@RestController
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/author")
    public List<Author> listPage() {
        return authorService.getAll();
    }
}
