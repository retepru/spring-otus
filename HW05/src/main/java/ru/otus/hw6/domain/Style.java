package ru.otus.hw6.domain;

import java.util.Objects;

public class Style {
    private Long id;
    private String name;

    public Style() {
    }

    public Style(Long id, String name) {
        this.id = id;
        this.name = name;
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
        return "Style{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Style style = (Style) o;
        return Objects.equals(id, style.id) && Objects.equals(name, style.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
