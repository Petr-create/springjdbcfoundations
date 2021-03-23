package ru.itsjava.dao.userdao;

import ru.itsjava.domain.User;

public interface UserJdbc {
    void insertUser(User user);
    User getUserById(long id);
    int countAllUsers();
}
