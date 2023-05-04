package ru.otus.spring.service;

import ru.otus.spring.domain.User;
import ru.otus.spring.io.ConsoleOut;

public class AppRun {

    private ConsoleOut consoleOut;
    private QuizService quizService;
    private UserService userService;

    public AppRun(QuizService quizService, UserService userService, ConsoleOut consoleOut) {
        this.quizService = quizService;
        this.userService = userService;
        this.consoleOut = consoleOut;
    }

    public void run() {
        User user = userService.createUser();
        quizService.askQuestions();
        long count = quizService.getNumberCorrectAnswers();
        consoleOut.println(user.getFirstName() + " gave " + count + " correct answers");
    }
}
