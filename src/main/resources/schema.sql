DROP TABLE IF EXISTS users, theme;

CREATE TABLE users(
    id bigint not null auto_increment primary key,
    name varchar (150),
    email varchar (200),
    password varchar (300)
);

CREATE TABLE theme(
  id bigint not null auto_increment primary key,
  letterName varchar (250),
  idUser bigint not null
);

CREATE TABLE messages(
    id bigint auto_increment primary key,
    textMessage varchar (1500),
    idTheme bigint not null,
    idUser bigint not null
);

ALTER TABLE theme ADD FOREIGN KEY (idUser) REFERENCES users(id);