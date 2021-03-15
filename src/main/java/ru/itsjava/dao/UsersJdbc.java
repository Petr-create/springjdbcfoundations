package ru.itsjava.dao;

import ru.itsjava.domain.Messages;
import ru.itsjava.domain.Themes;
import ru.itsjava.domain.Users;

import java.util.List;

public interface UsersJdbc {
    int countMessagesByName(String name);
    void insertUser(Users user);
    Users getUseById(long id);
    int countAllUsers();
    List<String> getThemeByIdUsers(long idUser);
    List<Themes> getThemeByIdUsers2(long idUser);
    List<Messages> getMessageByIdUser(long idUser, long idTheme);
    void insertMessage(Messages message);
    void insertTheme(Themes theme);
}
