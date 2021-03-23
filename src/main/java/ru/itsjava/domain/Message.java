package ru.itsjava.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Message {
    private long id;
    private final String textMessage;
    private final long idUsers;
    private final long idThemes;
}
