package ru.otus.spring.domain;

import java.util.Objects;

public class Answer {
    private final String text;

    private final boolean rightAnswer;

    public Answer(String text, boolean rightAnswer) {
        this.text = text;
        this.rightAnswer = rightAnswer;
    }

    public String getText() {
        return text;
    }

    public boolean isRightAnswer() {
        return rightAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return rightAnswer == answer.rightAnswer && text.equals(answer.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, rightAnswer);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "text='" + text + '\'' +
                ", rightAnswer=" + rightAnswer +
                '}';
    }
}
