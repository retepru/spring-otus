package ru.otus.hw6.repositories;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.otus.hw6.domain.Author;
import ru.otus.hw6.domain.Book;
import ru.otus.hw6.domain.Comment;
import ru.otus.hw6.domain.Style;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@DisplayName("Репозиторий на основе Jpa Book")
@DataJpaTest
class BookRepositoryTest {
    private static final int EXPECTED_NUMBER_OF_BOOKS = 2;
    private static final long FIRST_BOOKS_ID = 1l;

    private static final long EXPECTED_QUERIES_COUNT = 1l;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TestEntityManager em;

    @DisplayName("Тест количества книг")
    @Test
    void count() {
        assertThat(EXPECTED_NUMBER_OF_BOOKS).isEqualTo(bookRepository.count());
    }

    @DisplayName(" должен корректно сохранить всю информацию по книге")
    @Test
    void shouldSaveAllBookInfo() {
        Author author = new Author(null, "Чернышевский");
        Style style = new Style(null, "Роман");
        List<Comment> comments = Arrays.asList(new Comment("первый комментарий"), new Comment("Второй комментарий"));

        Book book = new Book(null, "Что делать", author, style, comments);
        bookRepository.save(book);

        assertThat(book.getId()).isNotNull();

        Book actualBook = em.find(Book.class, book.getId());
        assertThat(actualBook).isNotNull().matches(b -> !b.getName().equals(""))
                .matches(b -> b.getAuthor() != null)
                .matches(b -> b.getStyle() != null)
                .matches(b -> b.getComments().size() > 0);
    }

    @DisplayName(" должен изменить название книга по заданному id")
    @Test
    void shouldUpdateNameBookId() {

    }

    @DisplayName("Проверяем загрузку книгу по её id")
    @Test
    void shouldFindExpectedBookById() {
        Book actualBook = em.find(Book.class, FIRST_BOOKS_ID);
        Optional<Book> optionalExpectedBook = bookRepository.findById(FIRST_BOOKS_ID);
        assertThat(optionalExpectedBook).isPresent().get()
                .usingRecursiveComparison().isEqualTo(actualBook);
    }

    @DisplayName("должен загружать список всех книг с полной информацией о них")
    @Test
    void shouldReturnCorrectBooksListWithAllInfo() {
        List<Book> expectedBooks = bookRepository.findAll();
        assertThat(expectedBooks).isNotNull().hasSize(EXPECTED_NUMBER_OF_BOOKS)
                .allMatch(b -> !b.getName().equals(""))
                .allMatch(b -> b.getAuthor() != null)
                .allMatch(b -> b.getStyle() != null)
                .allMatch(b -> b.getComments() != null && b.getComments().size() > 0);
    }

    @DisplayName("Проверяем удаление книги по id")
    @Test
    void shouldDeleteBookById() {
        Book actualBook = em.find(Book.class, FIRST_BOOKS_ID);
        assertThat(actualBook).isNotNull();

        bookRepository.deleteById(FIRST_BOOKS_ID);

        Book expectedBook = em.find(Book.class, FIRST_BOOKS_ID);

        assertThat(expectedBook).isNull();
    }


    @DisplayName("Проверка количество запросов при выборке всех книг")
    @Test
    void checkNumberOfQuery() {
        SessionFactory sessionFactory = em.getEntityManager().getEntityManagerFactory()
                .unwrap(SessionFactory.class);
        sessionFactory.getStatistics().setStatisticsEnabled(true);

        List<Book> books = bookRepository.findAll();

        long c = sessionFactory.getStatistics().getPrepareStatementCount();

        assertThat(sessionFactory.getStatistics().getPrepareStatementCount()).isEqualTo(EXPECTED_QUERIES_COUNT);
    }

    // проверка на количество запросов в базу
}