package ru.itsjava.dao.userdao;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("ALL")
@Repository
@RequiredArgsConstructor
public class UserJdbcImpl implements UserJdbc {

    private final JdbcOperations jdbcOperations;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
    private Logger logger = Logger.getLogger(UserJdbcImpl.class);

    @Override
    public long insertUser(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update("insert into users (name, email, password) values (?,?,?)", user.getName(),
                user.getEmail(), user.getPassword(), keyHolder);
        return (long) keyHolder.getKey();
    }

    @Override
    public User getUserById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcOperations.queryForObject("select name, email, password from users where id = :id",
                params, new UserMapper());
    }

    @Override
    public int countAllUsers() {
        return jdbcOperations.queryForObject("select count(*) from users", Integer.class);
    }

    private static class UserMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User(
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );
        }
    }
}
