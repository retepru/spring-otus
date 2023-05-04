package ru.otus.spring.service;

import ru.otus.spring.domain.User;
import ru.otus.spring.io.ConsoleIn;
import ru.otus.spring.io.ConsoleOut;

public class UserServiceImpl implements UserService {

    private ConsoleIn consoleIn;
    private ConsoleOut consoleOut;

    public UserServiceImpl(ConsoleIn consoleIn, ConsoleOut consoleOut) {
        this.consoleIn = consoleIn;
        this.consoleOut = consoleOut;
    }

    @Override
    public User createUser() {
        consoleOut.println("Please enter your last name:");
        String lastName = consoleIn.getString();
        consoleOut.println("Please enter your first name:");
        String firstName = consoleIn.getString();
        return new User(lastName, firstName);
    }
}
