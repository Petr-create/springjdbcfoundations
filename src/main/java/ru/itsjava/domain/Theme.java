package ru.itsjava.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Theme {
    private long id;
    private final String letterName;
    private final long idUser;

}
