package ru.otus.hw6.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.otus.hw6.domain.Author;
import ru.otus.hw6.domain.Book;
import ru.otus.hw6.domain.Style;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Dao для работы с книгами должно")
@JdbcTest
@Import({BookDaoJdbc.class, AuthorDaoJdbc.class, StyleDaoJdbc.class})
class BookDaoJdbcTest {

    @Autowired
    private BookDaoJdbc bookDao;

    @Mock
    private AuthorDao authorDao;

    @Mock
    private StyleDao styleDao;

    private Author author;

    private Style style;

    private final long EXISTING_BOOK_ID = 1l;
    private static final long EXPECTED_PERSONS_COUNT = 1;

    @BeforeEach
    void init() {
        author = new Author(1l, "Шолохов");
        style = new Style(1l, "Исторический роман");
    }

    @DisplayName("возвращать ожидаемое количество книг в БД")
    @Test
    void shouldReturnExpectedBooksCount() {
        long actualBooksCount = bookDao.count();
        assertThat(actualBooksCount).isEqualTo(EXPECTED_PERSONS_COUNT);
    }

    @DisplayName("возвращать ожидаемую книгу в БД")
    @Test
    void shouldReturnBookById() {
        Book expectedBook = new Book(EXISTING_BOOK_ID, "Тихий дон", author, style);
        expectedBook.setAuthor(author);
        expectedBook.setStyle(style);

        Mockito.when(authorDao.getAll()).thenReturn(Arrays.asList(author));
        Mockito.when(styleDao.getAll()).thenReturn(Arrays.asList(style));

        Optional<Book> actualBook = bookDao.getById(expectedBook.getId());
        assertThat(actualBook).usingDefaultComparator().isEqualTo(expectedBook);
    }

    @DisplayName("возвращать ожидаемую книгу в БД которой нет")
    @Test
    void shouldReturnBookByIdNotFound() {

    }

    @DisplayName("должен добавить книгу в БД")
    @Test
    void insert() {
        Book expectedBook = new Book(2l, "testNameBook", author, style);
        bookDao.insert(expectedBook);
        expectedBook.setAuthor(author);
        expectedBook.setStyle(style);
        Optional<Book> actualBook = bookDao.getById(expectedBook.getId());
        assertThat(actualBook).usingDefaultComparator().isEqualTo(expectedBook);
    }

    @DisplayName("тест обновления книги в БД")
    @Test
    void update() {
        Mockito.when(authorDao.getAll()).thenReturn(Arrays.asList(author));
        Mockito.when(styleDao.getAll()).thenReturn(Arrays.asList(style));
        Optional<Book> expectedBook = bookDao.getById(EXISTING_BOOK_ID);

        expectedBook.get().setName(expectedBook.get().getName() + "test");
        // Todo добавить обновление автора и стиля.

        bookDao.update(expectedBook.get());

        Optional<Book> actualBook = bookDao.getById(EXISTING_BOOK_ID);
        assertThat(actualBook).usingDefaultComparator().isEqualTo(expectedBook);
    }

    @DisplayName("удаление заданной книги по её id")
    @Test
    void shouldCorrectDeleteBookById() {
        assertThatCode(() -> bookDao.getById(EXISTING_BOOK_ID))
                .doesNotThrowAnyException();

        bookDao.deleteById(EXISTING_BOOK_ID);

        assertThatThrownBy(() -> bookDao.getById(EXISTING_BOOK_ID))
                .isInstanceOf(EmptyResultDataAccessException.class);
    }

    @DisplayName("возвращает ожидаемый список книг")
    @Test
    void getAll() {
        Book expectedBook = new Book(EXISTING_BOOK_ID, "Тихий дон", author, style);
        expectedBook.setAuthor(author);
        expectedBook.setStyle(style);
        List<Book> actualBookList = bookDao.getAll();
        assertThat(actualBookList)
                .containsExactlyInAnyOrder(expectedBook);

    }
}