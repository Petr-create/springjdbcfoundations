package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.dao.keyholder.MessageRepositorySimpleJDBCInsert;
import ru.itsjava.domain.Theme;
import ru.itsjava.services.Message.MessageService;
import ru.itsjava.services.Theme.ThemeService;
import ru.itsjava.services.User.UserService;

import java.sql.SQLException;


@SpringBootApplication
public class Application {
    public static void main(String[] args) throws SQLException {
        var context = SpringApplication.run(Application.class);
        var paramMessage = context.getBean(MessageService.class);
        var paramUser = context.getBean(UserService.class);
        var paramTheme = context.getBean(ThemeService.class);
        paramUser.createUser();
        paramMessage.createMessage();
        paramTheme.createTheme();

        var p = context.getBean(MessageRepositorySimpleJDBCInsert.class);
        System.out.println(p.insert(new Theme("Привет Мир!", 1L)));

        Console.main();
    }
}
