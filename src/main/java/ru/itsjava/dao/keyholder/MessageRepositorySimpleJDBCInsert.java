package ru.itsjava.dao.keyholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Theme;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MessageRepositorySimpleJDBCInsert {
    SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public MessageRepositorySimpleJDBCInsert(DataSource dataSource) {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("theme").usingGeneratedKeyColumns("id");
    }

    public long insert(Theme theme) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("letterName", theme.getLetterName());
        parameters.put("idUser", theme.getIdUser());
        Number newId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return (long) newId;
    }
}
