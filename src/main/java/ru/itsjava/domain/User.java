package ru.itsjava.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class User {
    private long id;
    private final String name;
    private final String email;
    private final String password;
}
