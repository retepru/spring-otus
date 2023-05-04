package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.dao.QuizDao;
import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Question;
import ru.otus.spring.io.Bundle;
import ru.otus.spring.io.ConsoleIn;
import ru.otus.spring.io.ConsoleOut;

import java.util.List;
import java.util.Map;

@Service
public class QuizServiceImpl implements QuizService {
    private final QuizDao quizDao;
    private final QuestionsService questionsService;
    private final ConsoleOut consoleOut;
    private final ConsoleIn consoleIn;
    private final Bundle bundle;

    public QuizServiceImpl(QuestionsService questionsService, ConsoleOut consoleOut, ConsoleIn consoleIn, Bundle bundle, QuizDao quizDao) {
        this.questionsService = questionsService;
        this.consoleOut = consoleOut;
        this.consoleIn = consoleIn;
        this.bundle = bundle;
        this.quizDao = quizDao;
    }

    @Override
    public void askQuestions() {
        List<Question> questions = questionsService.getAllQuestions();
        int countQuestion = 1;
        for (Question question : questions) {
            consoleOut.println(countQuestion + " " + question.getText());
            int countAnswer = 1;
            for (Answer answer : question.getAnswers()) {
                consoleOut.println("  " + countAnswer + " " + answer.getText());
                countAnswer++;
            }
            consoleOut.println(bundle.getString("enter.correct.answer.number"));
            int answer = getAnswerAsk();
            Answer answerUser = (question.getAnswers()).get(answer - 1);
            quizDao.addResult(question, answerUser);
            countQuestion++;
        }
    }

    @Override
    public long getNumberCorrectAnswers() {
        return quizDao.getAllResults().values().stream().filter(answer -> answer.isRightAnswer())
                .count();
    }

    @Override
    public void clearResult() {
        quizDao.clear();
    }

    @Override
    public Map<Question, Answer> getAllResults() {
        return quizDao.getAllResults();
    }

    private int getAnswerAsk() {
        boolean exit = true;
        while (exit) {
            String answer = consoleIn.getString();
            if (answer.matches("\\d+")) {
                return Integer.parseInt(answer);
            }
            else if (answer.equals("exit")) {
                exit = false;
            }
            else {
                consoleOut.println(bundle.getString("enter.correct.number"));
            }
        }
        return 0;
    }
}
