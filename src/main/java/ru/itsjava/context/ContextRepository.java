package ru.itsjava.context;

import lombok.AllArgsConstructor;
import org.h2.tools.Console;
import org.springframework.stereotype.Component;
import ru.itsjava.domain.Users;
import ru.itsjava.services.UsersService;

import java.sql.SQLException;

@AllArgsConstructor
@Component
public class ContextRepository {
    private UsersService usersService;

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
        System.out.println(usersService.getThemeByIdUsers(idUser));
    }
}
