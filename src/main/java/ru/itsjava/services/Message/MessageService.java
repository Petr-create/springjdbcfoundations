package ru.itsjava.services.Message;

import ru.itsjava.domain.Message;

import java.sql.SQLException;

public interface MessageService {
    void createMessage();

    void countMessagesByName(String name) throws SQLException;

    void insertMessage(Message message);

    void getMessageByIdUserAndByIdTheme(long idUser, long idTheme);

}
