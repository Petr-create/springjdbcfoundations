package ru.itsjava.context;

import lombok.RequiredArgsConstructor;
import org.h2.tools.Console;
import org.springframework.stereotype.Component;
import ru.itsjava.domain.Messages;
import ru.itsjava.domain.Themes;
import ru.itsjava.domain.Users;
import ru.itsjava.services.UsersService;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ContextRepository {
    private final UsersService usersService;

    public void countMessages(String name) throws SQLException {
        System.out.println("Количество сообщений у пользователей по имени " + name + ": "
                + usersService.countMessagesByName(name));
        Console.main();
    }
    public void countAllUsers(){
        System.out.println("Все пользователи: " + usersService.countAllUsers());
    }
    public void insertUser(Users user) {
        usersService.insertUser(user);
    }
    public void getUseById(long id){
        System.out.println(usersService.getUseById(id));
    }
    public void getThemeByIdUsers(long idUser){
        List<String> list = usersService.getThemeByIdUsers(idUser);
        for (String s : list){
            System.out.println(s);
        }
    }
    public void getThemeByIdUsers2(long idUser){
        List<Themes> list = usersService.getThemeByIdUsers2(idUser);
        for (Themes t : list){
            System.out.println(t.getLetterName());
        }
    }

    public void getMessageByIdUser(long idUser, long idTheme){
        List<Messages> list = usersService.getMessageByIdUser(idUser, idTheme);
        for (Messages t : list){
            System.out.println(t.getTextMessage());
        }
    }

    public void insertMessage(Messages messages){
        usersService.insertMessage(messages);
    }

    public void insertTheme(Themes theme){
        usersService.insertTheme(theme);
    }
}
