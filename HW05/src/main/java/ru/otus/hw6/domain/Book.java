package ru.otus.hw6.domain;

import java.util.Objects;

public class Book {
    private Long id;
    private String name;

    private Author author;
    private Style style;

    public Book() {}

    public Book(Long id, String name) {
        this(id, name, null, null);
    }

    public Book(Long id, String name, Author author, Style style) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.style = style;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(style, book.style);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, style);
    }
}
