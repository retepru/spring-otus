package ru.otus.spring.service;

import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Question;

import java.util.Map;

public interface QuizService {
    void askQuestions();
    long getNumberCorrectAnswers();

    void clearResult();

    Map<Question, Answer> getAllResults();
}
