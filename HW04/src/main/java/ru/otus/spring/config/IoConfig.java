package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.io.ConsoleIn;
import ru.otus.spring.io.ConsoleInScanner;
import ru.otus.spring.io.ConsoleOut;
import ru.otus.spring.io.ConsoleOutPrintStream;

@Configuration
public class IoConfig {

    @Qualifier("consoleOutPrintStream")
    @Bean
    public ConsoleOut consoleOut() {
        return new ConsoleOutPrintStream(System.out);
    }

    @Qualifier("consoleInScanner")
    @Bean
    public ConsoleIn consoleIn() {
        return new ConsoleInScanner(System.in);
    }
}
