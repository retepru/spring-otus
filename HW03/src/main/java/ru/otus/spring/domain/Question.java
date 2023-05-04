package ru.otus.spring.domain;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private final String text;

    private final List<Answer> answers ;

    public Question(String text, List<Answer> answers) {
        this.text = text;
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + text + '\'' +
                '}';
    }
}
