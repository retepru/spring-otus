package ru.otus.hw6.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw6.domain.Style;
import ru.otus.hw6.service.StyleService;

import java.util.List;

@ShellComponent
public class StyleCommands {
    private final StyleService styleService;

    public StyleCommands(StyleService styleService) {
        this.styleService = styleService;
    }

    @ShellMethod(value = "Получить все стили", key = {"s", "style"})
    public String getAll() {
        List<Style> styles = styleService.getAll();
        return styles.toString();
    }
}
