package ru.itsjava.dao.themedao;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.itsjava.dao.userdao.UserJdbc;
import ru.itsjava.dao.userdao.UserJdbcImpl;
import ru.itsjava.domain.Theme;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Repository
@RequiredArgsConstructor
public class ThemeJdbcImpl implements ThemeJdbc{
    private final JdbcOperations jdbcOperations;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
    private final UserJdbc userJdbc;
    private Logger logger = Logger.getLogger(UserJdbcImpl.class);

    @Override
    public List<String> getThemeByIdUsers(long idUser) {
        logger.info("\nПользователь по данному Id: " + userJdbc.getUserById(idUser));
        return jdbcOperations.queryForList("select letterName from theme where idUser = '" + idUser + "'",
                String.class);
    }

    @Override
    public List<Theme> getThemeByIdUserWithMap(long idUser) {
        logger.info("\nПользователь по данному Id: " + userJdbc.getUserById(idUser));
        Map<String, Long> params = new HashMap<>();
        params.put("idUser", idUser);
        return namedParameterJdbcOperations.query("select letterName, idUser from theme where idUser = :idUser",
                params, new ThemesMapper());
    }

    @Override
    public void insertTheme(Theme theme) {
        //jdbcOperations.update("insert into theme (letterName, idUser) values (?,?)", theme.getLetterName(), theme.getIdUser());
        namedParameterJdbcOperations.update("insert into theme (letterName, idUser) values (:letterName,:idUser)",
                Map.of("letterName", theme.getLetterName(), "idUser", theme.getIdUser()));
    }

    private static class ThemesMapper implements RowMapper<Theme> {
        @Override
        public Theme mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Theme(
                          resultSet.getString("letterName"),
                          resultSet.getLong("idUser")
            );
        }
    }
}
