package ru.otus.spring.dao;

import ru.otus.spring.domain.User;

public interface UserDao {
    User create(User user);
    User getUser();
}
