package ru.otus.spring.io;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleInScanner implements ConsoleIn {
    private Scanner scanner;

    public ConsoleInScanner(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public String getString() {
        return scanner.next();
    }

    @Override
    public int getInt() {
        return scanner.nextInt();
    }
}
