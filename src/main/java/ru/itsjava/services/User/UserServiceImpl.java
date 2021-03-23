package ru.itsjava.services.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.userdao.UserJdbc;
import ru.itsjava.domain.User;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final UserJdbc userJdbc;

    @Override
    public void createUser() {
        insertUser(new User("Валерий", "valera@yandex.ru", "10110"));
        getUserById(3L);
        countAllUsers();
    }

    @Override
    public void insertUser(User user) {
        userJdbc.insertUser(user);
    }

    @Override
    public void getUserById(long id) {
        System.out.println(userJdbc.getUserById(id));
    }

    @Override
    public void countAllUsers() {
        System.out.println("Все пользователи: " + userJdbc.countAllUsers());
    }

}
