package ru.otus.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.io.ConsoleIn;
import ru.otus.spring.io.ConsoleInScanner;
import ru.otus.spring.io.ConsoleOut;
import ru.otus.spring.io.ConsoleOutPrintStream;

@Configuration
public class IoConfig {
    @Bean
    public ConsoleOut consoleOut() {
        return new ConsoleOutPrintStream(System.out);
    }

    @Bean
    public ConsoleIn consoleIn() {
        return new ConsoleInScanner(System.in);
    }
}
