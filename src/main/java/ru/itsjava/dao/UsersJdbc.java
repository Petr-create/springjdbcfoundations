package ru.itsjava.dao;

import ru.itsjava.domain.Users;

public interface UsersJdbc {
    int countMessagesByName(String name);
    void insertUser(Users user);
    Users getUseById(long id);
    int countAllUsers();
    String getThemeByIdUsers(long idUser);
}
