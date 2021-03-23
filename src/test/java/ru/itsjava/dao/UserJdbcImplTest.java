package ru.itsjava.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.dao.messagedao.MessageJdbc;
import ru.itsjava.dao.themedao.ThemeJdbc;
import ru.itsjava.dao.themedao.ThemeJdbcImpl;
import ru.itsjava.dao.userdao.UserJdbc;
import ru.itsjava.dao.userdao.UserJdbcImpl;
import ru.itsjava.domain.Message;
import ru.itsjava.domain.Theme;
import ru.itsjava.domain.User;

@JdbcTest
@Import(UserJdbcImpl.class)
public class UserJdbcImplTest {

    @Autowired
    private UserJdbc userJdbc;
    @Autowired
    private MessageJdbc messageJdbc;
    @Autowired
    private ThemeJdbc themeJdbc;

    @Test
    public void shouldHaveCorrectInsert(){
        User testUser = new User("Test name", "ok@test.ru", "12345");
        userJdbc.insertUser(testUser);
        Assertions.assertEquals(testUser, userJdbc.getUserById(1L));
    }


    @Test
    public void shouldHaveCorrectGetMessageByIdUser(){
        User testUser = new User("Test name", "ok@test.ru", "12345");
        userJdbc.insertUser(testUser);
        Theme theme = new Theme("TestTheme", 1L);
        themeJdbc.insertTheme(theme);
        Message message = new Message("TestMessage", 1L, 1L);
        messageJdbc.insertMessage(message);
        //List<Message> list = Arrays.asList(message);
        Assertions.assertEquals(message, messageJdbc.getMessageByIdUserAndByIdTheme(1, 1).get(0));
    }
}
