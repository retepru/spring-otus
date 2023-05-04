package ru.otus.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.dao.QuestionsRead;
import ru.otus.spring.io.ConsoleIn;
import ru.otus.spring.io.ConsoleOut;
import ru.otus.spring.service.*;

@Configuration
public class ServiceConfig {
    @Bean
    public QuestionsService questionsService(QuestionsRead questionsRead, ConsoleOut consoleOut) {
        return new QuestionsServiceImpl(questionsRead, consoleOut);
    }

    @Bean
    public QuizService QuizServiceImpl(QuestionsService questionsService, ConsoleOut consoleOut, ConsoleIn consoleIn) {
        return new QuizServiceImpl(questionsService, consoleOut, consoleIn);
    }

    @Bean
    public UserService UserServiceImpl(ConsoleIn consoleIn, ConsoleOut consoleOut) {
        return new UserServiceImpl(consoleIn, consoleOut);
    }

    @Bean
    public AppRun appRun(QuizService quizService, UserService userService, ConsoleOut consoleOut) {
        return new AppRun(quizService, userService, consoleOut);
    }
}
