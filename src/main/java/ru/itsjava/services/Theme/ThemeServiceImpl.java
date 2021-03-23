package ru.itsjava.services.Theme;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.themedao.ThemeJdbc;
import ru.itsjava.domain.Theme;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemeServiceImpl  implements ThemeService {
    final ThemeJdbc themeJdbc;

    @Override
    public void createTheme() {
        getThemeByIdUser(2L);
        getThemeByIdUserWithMap(2L);
        insertTheme(new Theme("Тема Тема Тема", 3));
    }


    @Override
    public void getThemeByIdUser(long idUser) {
        List<String> list = themeJdbc.getThemeByIdUsers(idUser);
        for (String s : list){
            System.out.println(s);
        }
    }

    @Override
    public void getThemeByIdUserWithMap(long idUser) {
        List<Theme> list = themeJdbc.getThemeByIdUserWithMap(idUser);
        for (Theme t : list){
            System.out.println(t.getLetterName());
        }
    }

    @Override
    public void insertTheme(Theme theme) {
        themeJdbc.insertTheme(theme);
    }
}
