package ru.otus.spring.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;
import ru.otus.spring.config.AppProps;
import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Question;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Component
public class QuestionsReadCsv implements QuestionsRead {
    private final AppProps appProps;

    public QuestionsReadCsv(AppProps appProps) {
        this.appProps = appProps;
    }

    public List<String[]> getListString() {

        String path = getClass().getClassLoader().getResource(appProps.getFileName()).getPath();

        try (FileReader fileReader = new FileReader(path);
             CSVReader csvReader = new CSVReader(fileReader)) {
            return csvReader.readAll();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Question> getAllQuestions() {
        List<String[]> listStringArray = getListString();

        if (listStringArray.size() == 0) {
            return null;
        }

        List<Question> questions = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();
        Question currentQuestion = new Question(listStringArray.get(0)[0], answers);
        questions.add(currentQuestion);

        for (String[] string : listStringArray) {
            if (currentQuestion.getText().equals(string[0])) {
                answers.add(new Answer(string[1], Boolean.parseBoolean(string[2])));
            }
            else {
                answers = new ArrayList<>();
                answers.add(new Answer(string[1], Boolean.parseBoolean(string[2])));
                currentQuestion = new Question(string[0], answers);
                questions.add(currentQuestion);
            }
        }
        return questions;
    }
}
