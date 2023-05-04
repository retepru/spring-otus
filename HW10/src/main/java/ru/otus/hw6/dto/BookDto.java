package ru.otus.hw6.dto;

import lombok.Getter;
import lombok.Setter;
import ru.otus.hw6.domain.Book;

@Getter
@Setter
public class BookDto {
    private long id;
    private String name;
    private String author;
    private long authorId;
    private String style;
    private long styleId;

    public BookDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public BookDto(long id, String name, String author, long authorId, String style, long styleId) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.authorId = authorId;
        this.style = style;
        this.styleId = styleId;
    }

    public static BookDto bookToBookDto(Book book) {
        return new BookDto(book.getId(), book.getName(), book.getAuthor().getName(), book.getAuthor().getId(), book.getStyle().getName(), book.getStyle().getId());
    }
}
