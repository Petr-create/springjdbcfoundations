package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Messages;
import ru.itsjava.domain.Themes;
import ru.itsjava.domain.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings("ALL")
@Repository
@RequiredArgsConstructor
public class UsersJdbcImpl implements UsersJdbc{

    private final JdbcOperations jdbcOperations;
    private final NamedParameterJdbcOperations paramsjdbcOperations;

    @Override
    public List<Themes> getThemeByIdUsers2(long idUser) {
        System.out.println();
        System.out.println(getUseById(idUser));
        Map<String, Long> params = new HashMap<>();
        params.put("idUser", idUser);
        return paramsjdbcOperations.query("select letterName from theme where idUser = :idUser",
                params, new ThemesMapper());
    }


    @Override
    public List<String> getThemeByIdUsers(long idUser) {
        System.out.println();
        System.out.println(getUseById(idUser));
        return jdbcOperations.queryForList("select letterName from theme where idUser = '" + idUser + "'",
                String.class);
    }

    @Override
    public int countMessagesByName(String name) {
        return jdbcOperations.queryForObject("select count(*) from users where name = '" + name +"'",
                Integer.class);
    }

    @Override
    public void insertUser(Users user) {
        jdbcOperations.update("insert into users (name, email, password) values (?,?,?)", user.getName(),
                user.getEmail(), user.getPassword());
    }

    @Override
    public Users getUseById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return paramsjdbcOperations.queryForObject("select name, email, password from users where id = :id",
                params, new UserMapper());
    }

    @Override
    public int countAllUsers() {
        return jdbcOperations.queryForObject("select count(*) from users", Integer.class);
    }

    private static class UserMapper implements RowMapper<Users>{
        @Override
        public Users mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Users(
                             resultSet.getString("name"),
                             resultSet.getString("email"),
                             resultSet.getString("password")
            );
        }
    }

    private static class ThemesMapper implements RowMapper<Themes>{
        @Override
        public Themes mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Themes(
                          resultSet.getString("letterName"),
                          resultSet.getLong("idUser")
            );
        }
    }

    private static class MessagesMapper implements RowMapper<Messages>{
        @Override
        public Messages mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Messages(
                            resultSet.getString("textMessage"),
                            resultSet.getLong("idUsers"),
                            resultSet.getLong("idThemes")
            );
        }
    }
}
