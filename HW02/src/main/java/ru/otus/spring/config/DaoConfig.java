package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.spring.dao.QuestionsRead;
import ru.otus.spring.dao.QuestionsReadCsv;

@Configuration
@PropertySource("classpath:application.properties")
public class DaoConfig {

    @Bean
    public QuestionsRead questionsRead(@Value("${questionsFile}") String fileName) {
        return new QuestionsReadCsv(fileName);
    }


}
