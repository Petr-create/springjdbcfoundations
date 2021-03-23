package ru.itsjava.services.Message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.messagedao.MessageJdbc;
import ru.itsjava.domain.Message;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl  implements MessageService {
    final MessageJdbc messageJdbc;

    @Override
    public void createMessage(){
        try {
            countMessagesByName("Виталий");
        }catch (SQLException e){
            e.getSQLState();
        }
        insertMessage(new Message("Привет Мир!!!", 1, 3));
        getMessageByIdUserAndByIdTheme(2L, 1L);
    }

    @Override
    public void countMessagesByName(String name) throws SQLException {
        System.out.println("Количество сообщений у пользователей по имени " + name + ": "
                + messageJdbc.countMessagesByName(name));
    }

    @Override
    public void insertMessage(Message message) {
        messageJdbc.insertMessage(message);
    }

    @Override
    public void getMessageByIdUserAndByIdTheme(long idUser, long idTheme) {
        List<Message> list = messageJdbc.getMessageByIdUserAndByIdTheme(idUser, idTheme);
        for (Message t : list){
            System.out.println(t.getTextMessage());
        }
    }

}
