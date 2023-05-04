package ru.otus.hw6.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.hw6.domain.Style;
import ru.otus.hw6.service.StyleService;

import java.util.List;

@RestController
public class StyleController {
    private StyleService styleService;

    public StyleController(StyleService styleService) {
        this.styleService = styleService;
    }

    @GetMapping("/style")
    public List<Style> styleList() {
        return styleService.getAll();
    }
}
