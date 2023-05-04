package ru.otus.hw6.service;

import org.springframework.stereotype.Service;
import ru.otus.hw6.domain.Style;
import ru.otus.hw6.repositories.StyleDao;

import java.util.List;

@Service
public class StyleService {
    private StyleDao styleDao;

    public StyleService(StyleDao styleDao) {
        this.styleDao = styleDao;
    }

    public List<Style> getAll() {
        return styleDao.findAll();
    }
}
