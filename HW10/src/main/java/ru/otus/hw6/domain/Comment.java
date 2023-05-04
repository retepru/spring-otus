package ru.otus.hw6.domain;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="text", nullable = false)
    private String text;

    @JoinColumn(name="book_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Comment() {
    }

    public Comment(String text) {
        this.text = text;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
