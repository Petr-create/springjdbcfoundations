package ru.itsjava.services.Theme;

import ru.itsjava.domain.Theme;

public interface ThemeService {
    void createTheme();

    void getThemeByIdUser(long idUser);

    void getThemeByIdUserWithMap(long idUser);

    void insertTheme(Theme theme);

}
