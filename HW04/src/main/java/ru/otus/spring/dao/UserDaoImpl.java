package ru.otus.spring.dao;

import org.springframework.stereotype.Component;
import ru.otus.spring.domain.User;

@Component
public class UserDaoImpl implements UserDao {

    private User user;

    @Override
    public User create(User user) {
        return this.user = user;
    }

    @Override
    public User getUser() {
        return this.user;
    }
}
