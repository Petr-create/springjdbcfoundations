package ru.itsjava.dao.themedao;

import ru.itsjava.domain.Theme;

import java.util.List;

public interface ThemeJdbc {
    List<String> getThemeByIdUsers(long idUser);
    List<Theme> getThemeByIdUserWithMap(long idUser);
    void insertTheme(Theme theme);

}
