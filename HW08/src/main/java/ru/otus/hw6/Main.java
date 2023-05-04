package ru.otus.hw6;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.sql.SQLException;
@EnableMongock
@EnableMongoRepositories
@SpringBootApplication
public class Main {
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Main.class, args);
	}
}
