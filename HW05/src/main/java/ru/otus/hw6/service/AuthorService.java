package ru.otus.hw6.service;

import org.springframework.stereotype.Service;
import ru.otus.hw6.dao.AuthorDao;
import ru.otus.hw6.domain.Author;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private AuthorDao authorDao;

    public AuthorService (AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public void create(Author author) {
        authorDao.insert(author);
    }

    public void deleteById(long id) {
        authorDao.deleteById(id);
    }
    public List<Author> getAll() {
        return authorDao.getAll();
    }

    public String getById(Long id) {
        Optional<Author> author = authorDao.getById(id);
        if (author.isPresent()) {
            return author.get().toString();
        }
        else {
            return "Такого автора нет";
        }
    }
    public void update(Author author) {
        authorDao.update(author);
    }

    public void count() {
        authorDao.count();
    }
}
