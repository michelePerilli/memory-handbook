CREATE
DATABASE handbook;
USE
DATABASE handbook;

CREATE TABLE passwords
(
    id             integer primary key,
    email          varchar(),
    username       varchar(),
    password       varchar(),
    descrizione    varchar(),
    flag_eliminato varchar()
);
INSERT INTO passwords(id, email, username, password, descrizione, flag_eliminato)
VALUES (1, 'email', 'username', 'password', 'descrizione', 's'),
       (2, 'email', 'username', 'password', 'descrizione', 's');
