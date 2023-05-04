package ru.otus.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.Main;
import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Question;
import ru.otus.spring.dao.QuestionsReadCsv;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class QuestionsServiceImplTest {

    @Test
    public void getAllQuestions() {
        List<Answer> a1 = new ArrayList<>(Arrays.asList(
                new Answer("Left", false),
                new Answer("Right", true)
        ));
        Question q1 = new Question("question 2", a1);

        List<Question> actualQuestions = new ArrayList<>(Arrays.asList(q1));

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        QuestionsReadCsv QuestionsRead = context.getBean(QuestionsReadCsv.class);

        List<Question> expectedQuestions = QuestionsRead.getAllQuestions();

        assertThat(actualQuestions).usingRecursiveComparison().isEqualTo(expectedQuestions);
    }
}