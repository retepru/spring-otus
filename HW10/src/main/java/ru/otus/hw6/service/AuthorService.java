package ru.otus.hw6.service;

import org.springframework.stereotype.Service;
import ru.otus.hw6.repositories.AuthorRepository;
import ru.otus.hw6.domain.Author;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService (AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public void create(Author author) {
        authorRepository.save(author);
    }

    @Transactional
    public void deleteById(long id) {
        authorRepository.deleteById(id);
    }
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> getById(Long id) {
        return authorRepository.findById(id);
    }
    @Transactional
    public void update(Author author) {
        authorRepository.save(author);
    }

    public void count() {
        authorRepository.count();
    }
}
