package ru.itsjava.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Messages;
import ru.itsjava.domain.Themes;
import ru.itsjava.domain.Users;

import java.util.Arrays;
import java.util.List;

@JdbcTest
@Import(UsersJdbcImpl.class)
public class UsersJdbcImplTest {

    @Autowired
    private UsersJdbc usersJdbc;

    @Test
    public void shouldHaveCorrectInsert(){
        Users testUser = new Users("Test name", "ok@test.ru", "12345");
        usersJdbc.insertUser(testUser);
        Assertions.assertEquals(testUser, usersJdbc.getUseById(1L));
    }


    @Test
    public void shouldHaveCorrectGetMessageByIdUser(){
        Users testUser = new Users("Test name", "ok@test.ru", "12345");
        usersJdbc.insertUser(testUser);
        Themes themes = new Themes("TestTheme", 1L);
        usersJdbc.insertTheme(themes);
        Messages messages = new Messages("TestMessage", 1L, 1L);
        usersJdbc.insertMessage(messages);
        List<Messages> list = Arrays.asList(messages);
        Assertions.assertEquals(list, usersJdbc.getMessageByIdUser(1, 1));
    }
}
