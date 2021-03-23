package ru.itsjava.dao.messagedao;

import ru.itsjava.domain.Message;

import java.util.List;

public interface MessageJdbc {
    int countMessagesByName(String name);
    List<Message> getMessageByIdUserAndByIdTheme(long idUser, long idTheme);
    void insertMessage(Message message);
}
