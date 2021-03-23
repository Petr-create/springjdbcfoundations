package ru.itsjava.services.User;

import ru.itsjava.domain.User;

public interface UserService {
    void createUser();

    void insertUser(User user);

    void getUserById(long id);

    void countAllUsers();
}
