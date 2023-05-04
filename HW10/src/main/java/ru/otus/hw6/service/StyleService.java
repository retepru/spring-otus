package ru.otus.hw6.service;

import org.springframework.stereotype.Service;
import ru.otus.hw6.domain.Author;
import ru.otus.hw6.domain.Style;
import ru.otus.hw6.repositories.StyleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StyleService {
    private StyleRepository styleRepository;

    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    public List<Style> getAll() {
        return styleRepository.findAll();
    }

    public Optional<Style> getById(Long id) {
        return styleRepository.findById(id);
    }
}
