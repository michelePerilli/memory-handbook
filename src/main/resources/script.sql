create extension if not exists "uuid-ossp";

drop schema if exists handbook cascade ;
create schema handbook;
CREATE TABLE handbook.passwords
(
    id             uuid DEFAULT uuid_generate_v4(),
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

