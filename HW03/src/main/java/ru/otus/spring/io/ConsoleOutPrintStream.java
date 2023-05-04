package ru.otus.spring.io;

import org.springframework.stereotype.Component;

import java.io.PrintStream;

public class ConsoleOutPrintStream implements ConsoleOut{

    private final PrintStream printStream;

    public ConsoleOutPrintStream(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void print(String message) {
        printStream.print(message);
    }

    @Override
    public void println(String message) {
        printStream.println(message);
    }
}
