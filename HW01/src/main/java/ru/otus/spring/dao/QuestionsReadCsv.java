package ru.otus.spring.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Question;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class QuestionsReadCsv implements QuestionsRead {
    String fileName;

    public QuestionsReadCsv(String fileName) {
        this.fileName = fileName;
    }

    public List<String[]> getListString() {

        String name = getClass().getClassLoader().getResource(fileName).getPath();

        try (FileReader fileReader = new FileReader(name);
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
