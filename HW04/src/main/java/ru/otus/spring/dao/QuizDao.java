package ru.otus.spring.dao;

import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Question;

import java.util.Map;

public interface QuizDao {
    Map<Question, Answer> getAllResults();
    void addResult(Question question, Answer answer);
    void clear();


}
