package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.domain.User;
import ru.otus.spring.io.Bundle;
import ru.otus.spring.io.ConsoleIn;
import ru.otus.spring.io.ConsoleOut;

@Service
public class UserServiceImpl implements UserService {

    private final ConsoleIn consoleIn;
    private final ConsoleOut consoleOut;
    private final Bundle bundle;

    public UserServiceImpl(ConsoleIn consoleIn, ConsoleOut consoleOut, Bundle bundle) {
        this.consoleIn = consoleIn;
        this.consoleOut = consoleOut;
        this.bundle = bundle;
    }

    @Override
    public User createUser() {
        consoleOut.println(bundle.getString("enter.your.lastname"));
        String lastName = consoleIn.getString();
        consoleOut.println(bundle.getString("enter.your.firstname"));
        String firstName = consoleIn.getString();
        return new User(lastName, firstName);
    }
}
