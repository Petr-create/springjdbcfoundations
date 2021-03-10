package ru.itsjava.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Users;

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
}
