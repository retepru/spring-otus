package ru.otus.spring.dao;

import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Question;

import java.util.HashMap;
import java.util.Map;

@Component
public class QuizDaoImpl implements QuizDao {
    private final Map<Question, Answer> result;

    public QuizDaoImpl() {
        this.result = new HashMap<>();
    }

    @Override
    public Map<Question, Answer> getAllResults() {
        return result;
    }

    @Override
    public void addResult(Question question, Answer answer) {
        result.put(question, answer);
    }

    @Override
    public void clear() {
        result.clear();
    }
}
