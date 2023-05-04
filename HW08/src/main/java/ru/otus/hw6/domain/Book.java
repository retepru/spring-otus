package ru.otus.hw6.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "books")
public class Book {
    @Id
    private Long id;

    private String name;

    @DBRef
    private Author author;

    @DBRef
    private Style style;

    @DBRef(lazy = true)
    private List<Comment> comments;

    public Book() {}

    public Book(Long id, String name) {
        this(id, name, null, null, null);
    }
    public Book(Long id, String name, Author author, Style style, List<Comment> comments) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.style = style;
        this.comments = comments;
    }

    public Book(Long id, String name, Author author, Style style) {
        this(id, name, author, style, null);
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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

    public boolean isNew() {
        return id == null;
    }
}
