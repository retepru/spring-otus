package ru.otus.hw6.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.otus.hw6.domain.Author;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий на основе CrudRepository Author")
@DataJpaTest
class AuthorRepositoryTest {

    private static final int EXPECTED_NUMBER_OF_AUTHOR = 2;
    private static final long FIRST_AUTHOR_ID = 1;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TestEntityManager em;

    @DisplayName("Тест количества авторов")
    @Test
    void count() {
        assertThat(EXPECTED_NUMBER_OF_AUTHOR).isEqualTo(authorRepository.count());
    }

    @DisplayName("Тест проверки автора по id")
    @Test
    void findById() {
        Author actualAuthor = em.find(Author.class, FIRST_AUTHOR_ID);
        Optional<Author> optionalExpectedAuthor = authorRepository.findById(FIRST_AUTHOR_ID);
        assertThat(optionalExpectedAuthor).isPresent().get()
                .usingRecursiveComparison().isEqualTo(actualAuthor);
    }

    @DisplayName("Проверка сохранения автора")
    @Test
    void save() {
        // в этом тесте author и actualAuthor имеют одну и ту же ссылку на объект
        Author author = new Author(null, "Тестовый Автор");
        authorRepository.save(author);
        Author actualAuthor = em.find(Author.class, author.getId());

        assertThat(actualAuthor)
                .isNotNull()
                .matches(a -> !a.getName().equals(""))
                .matches(a -> a.getName().equals(author.getName()));

    }

    @DisplayName("Проверка удаления автора по id")
    @Test
    void deleteById() {
        Author actualAuthor  = em.find(Author.class, FIRST_AUTHOR_ID);
        assertThat(actualAuthor).isNotNull();

        authorRepository.deleteById(FIRST_AUTHOR_ID);

        Author expectedAuthor = em.find(Author.class, FIRST_AUTHOR_ID);
        assertThat(expectedAuthor).isNull();
    }

    @Test
    void findAll() {
        List<Author> expectedAuthor = authorRepository.findAll();
        assertThat(expectedAuthor)
                .isNotNull()
                .hasSize(EXPECTED_NUMBER_OF_AUTHOR)
                .allMatch(a -> !a.getName().equals(""));
    }
}