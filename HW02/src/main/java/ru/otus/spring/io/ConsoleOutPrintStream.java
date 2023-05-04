package ru.otus.spring.io;

import java.io.PrintStream;

public class ConsoleOutPrintStream implements ConsoleOut{

    private PrintStream printStream;

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
