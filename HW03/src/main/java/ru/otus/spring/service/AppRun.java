package ru.otus.spring.service;

import org.springframework.stereotype.Component;
import ru.otus.spring.domain.User;
import ru.otus.spring.io.Bundle;
import ru.otus.spring.io.ConsoleOut;

@Component
public class AppRun {

    private final QuizService quizService;
    private final UserService userService;
    private final Bundle bundle;
    private final ConsoleOut consoleOut;

    public AppRun(QuizService quizService, UserService userService, Bundle bundle, ConsoleOut consoleOut) {
        this.quizService = quizService;
        this.userService = userService;
        this.bundle = bundle;
        this.consoleOut = consoleOut;
    }

    public void run() {
        User user = userService.createUser();
        quizService.askQuestions();
        long count = quizService.getNumberCorrectAnswers();
        consoleOut.println(bundle.getString("you.result.test", user.getFirstName(), count));
    }
}
