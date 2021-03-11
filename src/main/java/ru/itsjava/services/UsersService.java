package ru.itsjava.services;

import ru.itsjava.domain.Themes;
import ru.itsjava.domain.Users;

import java.util.List;

public interface UsersService {
    int countMessagesByName(String name);
    void insertUser(Users user);
    Users getUseById(long id);
    int countAllUsers();
    List<String> getThemeByIdUsers(long idUser);
    List<Themes> getThemeByIdUsers2(long idUser);
}
