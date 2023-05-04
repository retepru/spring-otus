package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.service.QuestionsService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/SpringConfig.xml");

        QuestionsService questionsService = context.getBean(QuestionsService.class);

        questionsService.printQuestions();
    }
}
