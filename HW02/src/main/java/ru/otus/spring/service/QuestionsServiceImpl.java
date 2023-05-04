package ru.otus.spring.service;

import ru.otus.spring.domain.Question;
import ru.otus.spring.io.ConsoleOut;
import ru.otus.spring.dao.QuestionsRead;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class QuestionsServiceImpl implements QuestionsService{
    QuestionsRead questionsRead;
    ConsoleOut consoleOut;

    public QuestionsServiceImpl(QuestionsRead questionsRead, ConsoleOut consoleOut) {
        this.questionsRead = questionsRead;
        this.consoleOut = consoleOut;
    }

    @Override
    public void printQuestions() {
        List<Question> questions = questionsRead.getAllQuestions();
        AtomicInteger counterQuestion = new AtomicInteger(1);
        questions.stream().forEach(question -> {
            consoleOut.println(counterQuestion.getAndIncrement() + " " + question.getText());
            AtomicInteger counterAnswer = new AtomicInteger(1);
            question.getAnswers().stream().forEach(answer -> {
                consoleOut.println("  " + counterAnswer.getAndIncrement() + " " + answer.getText() + " " + answer.isRightAnswer());
            });
        });
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionsRead.getAllQuestions();
    }
}
