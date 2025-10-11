create extension if not exists "uuid-ossp";

drop schema if exists handbook cascade;
create schema handbook;
create table handbook.passwords
(
    id             uuid    default uuid_generate_v4(),
    email          varchar(255),
    username       varchar(255),
    password       varchar(255),
    descrizione    varchar(255),
    flag_eliminato boolean default false,
    created_at     timestamp,
    created_by     varchar(40),
    updated_at     timestamp,
    updated_by     varchar(40),
    constraint pk_passwords primary key (id)
);

create table handbook.utenti
(
    uuid         uuid default uuid_generate_v4(),
    sub          varchar(255) not null,
    nome         varchar(255),
    cognome      varchar(255),
    email        varchar(255),
    url_immagine varchar(512),
    created_at   timestamp,
    created_by   varchar(40),
    updated_at   timestamp,
    updated_by   varchar(40),
    constraint pk_utenti primary key (uuid)
)

