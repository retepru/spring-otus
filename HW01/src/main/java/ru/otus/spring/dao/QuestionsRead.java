package ru.otus.spring.dao;

import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Question;

import java.util.List;
import java.util.Map;

public interface QuestionsRead {
    List<Question> getAllQuestions();
}
