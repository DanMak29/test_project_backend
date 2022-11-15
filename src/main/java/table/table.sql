

create table country
(
    id           bigserial,
    country_name varchar(30) not null unique,
    primary key (id)
);

create table city
(
    id         bigserial,
    city_name  varchar(30) not null,
    country_id bigint,
    primary key (id),
    foreign key (country_id) references country (id)
);


create table employee
(
    id         bigserial,
    surname    varchar(30) not null,
    name       varchar(30) not null,
    number     varchar(30),
    email      varchar(30) not null,
    country_id bigint,
    city_id    bigint,
    primary key (id),
    foreign key (country_id) references country (id),
    foreign key (city_id) references city (id)
);


