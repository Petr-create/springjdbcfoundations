package ru.itsjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.context.ContextRepository;
import ru.itsjava.domain.Messages;
import ru.itsjava.domain.Themes;
import ru.itsjava.domain.Users;

import java.sql.SQLException;


@SpringBootApplication
public class Application {
    public static void main(String[] args) throws SQLException {
        var context = SpringApplication.run(Application.class);
        var param = context.getBean(ContextRepository.class);
        param.countMessages("Виталий");
        param.insertUser(new Users("Валерий", "valera@yandex.ru", "10110"));
        param.getUseById(3L);
        param.countAllUsers();
        param.getThemeByIdUsers(2L);
        param.getThemeByIdUsers2(2L);
        param.getMessageByIdUser(2L, 1L);
        param.insertMessage(new Messages("Привет Мир!!!", 1, 3));
        param.insertTheme(new Themes("Тема Тема Тема", 3));

//        System.out.println("Количество сообщений: " + context.getBean(UsersService.class).countMessagesByName("Виталий"));
//        context.getBean(UsersService.class).insertUser(new Users("Валерий", "valera@yandex.ru", "10110"));
//        System.out.println(context.getBean(UsersService.class).getUseById(3L));
//        Console.main();
    }
}
