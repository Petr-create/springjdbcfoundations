package ru.itsjava.services;

import ru.itsjava.domain.Users;

public interface UsersService {
    int countMessagesByName(String name);
    void insertUser(Users user);
    Users getUseById(long id);
    int countAllUsers();
    String getThemeByIdUsers(long idUser);
}
