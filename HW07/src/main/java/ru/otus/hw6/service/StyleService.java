package ru.otus.hw6.service;

import org.springframework.stereotype.Service;
import ru.otus.hw6.domain.Style;
import ru.otus.hw6.repositories.StyleRepository;

import java.util.List;

@Service
public class StyleService {
    private StyleRepository styleRepository;

    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    public List<Style> getAll() {
        return styleRepository.findAll();
    }
}
