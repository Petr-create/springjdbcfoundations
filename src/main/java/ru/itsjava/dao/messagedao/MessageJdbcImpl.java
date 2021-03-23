package ru.itsjava.dao.messagedao;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.itsjava.dao.themedao.ThemeJdbc;
import ru.itsjava.dao.userdao.UserJdbc;
import ru.itsjava.dao.userdao.UserJdbcImpl;
import ru.itsjava.domain.Message;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Repository
@RequiredArgsConstructor
public class MessageJdbcImpl implements MessageJdbc{

    private final JdbcOperations jdbcOperations;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
    private final UserJdbc userJdbc;
    private final ThemeJdbc themeJdbc;
    private Logger logger = Logger.getLogger(UserJdbcImpl.class);

    @Override
    public int countMessagesByName(String name) {
        return jdbcOperations.queryForObject("select count(*) from users where name = '" + name +"'",  Integer.class);

    }

    @Override
    public List<Message> getMessageByIdUserAndByIdTheme(long idUser, long idTheme) {
        logger.info("\nПользователь по данному Id: " + userJdbc.getUserById(idUser) + "\n" +
                "Темы пользователя по данному Id: " + themeJdbc.getThemeByIdUserWithMap(idUser));
        Map<String, Long> params = new HashMap<>();
        params.put("idUser", idUser);
        params.put("idTheme", idTheme);
        return namedParameterJdbcOperations.query("select textMessage, idTheme, idUser from messages where idUser = :idUser AND idTheme = :idTheme",
                params, new MessagesMapper());
    }

    @Override
    public void insertMessage(Message message) {
        jdbcOperations.update("insert into messages (textMessage, idTheme, idUser) values (?,?,?)", message.getTextMessage(),
                message.getIdThemes(), message.getIdUsers());
    }

    private static class MessagesMapper implements RowMapper<Message> {
        @Override
        public Message mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Message(
                            resultSet.getString("textMessage"),
                            resultSet.getLong("idTheme"),
                            resultSet.getLong("idUser")
            );
        }
    }
}
