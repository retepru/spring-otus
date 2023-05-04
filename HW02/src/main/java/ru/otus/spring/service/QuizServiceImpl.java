package ru.otus.spring.service;

import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Question;
import ru.otus.spring.io.ConsoleIn;
import ru.otus.spring.io.ConsoleOut;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizServiceImpl implements QuizService {
    private Map<Question, Answer> result;

    private QuestionsService questionsService;
    private ConsoleOut consoleOut;
    private ConsoleIn consoleIn;

    public QuizServiceImpl(QuestionsService questionsService, ConsoleOut consoleOut, ConsoleIn consoleIn) {
        this.questionsService = questionsService;
        this.consoleOut = consoleOut;
        this.consoleIn = consoleIn;
        result = new HashMap<>();
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
            int answer = getAnswerAsk();
            Answer answer1 = (question.getAnswers()).get(answer - 1);
            result.put(question, answer1);
            countQuestion++;
        }
    }

    @Override
    public long getNumberCorrectAnswers() {
        return result.values().stream().filter(answer -> answer.isRightAnswer())
                .count();
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
                consoleOut.println("Please enter a number or exit");
            }
        }
        return 0;
    }
}
