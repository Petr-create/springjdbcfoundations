package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.UsersJdbc;
import ru.itsjava.domain.Messages;
import ru.itsjava.domain.Themes;
import ru.itsjava.domain.Users;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService{

    private final UsersJdbc usersJdbc;

    @Override
    public int countMessagesByName(String name) {
        return usersJdbc.countMessagesByName(name);
    }

    @Override
    public void insertUser(Users user) {
        usersJdbc.insertUser(user);
    }

    @Override
    public Users getUseById(long id) {
        return usersJdbc.getUseById(id);
    }

    @Override
    public int countAllUsers() {
        return usersJdbc.countAllUsers();
    }

    @Override
    public List<String> getThemeByIdUsers(long idUser) {
        return usersJdbc.getThemeByIdUsers(idUser);
    }

    @Override
    public List<Themes> getThemeByIdUsers2(long idUser) {
        return usersJdbc.getThemeByIdUsers2(idUser);
    }

    @Override
    public List<Messages> getMessageByIdUser(long idUser, long idTheme) {
        return usersJdbc.getMessageByIdUser(idUser, idTheme);
    }

    @Override
    public void insertMessage(Messages message) {
         usersJdbc.insertMessage(message);
    }

    @Override
    public void insertTheme(Themes theme) {
        usersJdbc.insertTheme(theme);
    }
}
