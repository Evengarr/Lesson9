CREATE TABLE simple_products
(
    id         bigserial PRIMARY KEY,
    title      VARCHAR(255),
    cost       double precision,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);
INSERT INTO simple_products (title, cost)
VALUES ('aaa', 1.1),
       ('bbb', 2.15),
       ('ccc', 10.13),
       ('ddd', 5.5),
       ('eee', 50.15),
       ('fff', 32.3),
       ('ggg', 16.5),
       ('hhh', 100.5),
       ('iii', 95.9),
       ('jjj', 999.9),
       ('kkk', 235.35),
       ('lll', 361.01),
       ('mmm', 509.9),
       ('nnn', 55.9),
       ('ooo', 94.31),
       ('ppp', 888.9);

create table users
(
    id       bigserial,
    username varchar(30) not null,
    password varchar(80) not null,
    email    varchar(50) unique,
    score    bigserial,
    primary key (id)
);

create table roles
(
    id   serial,
    name varchar(50) not null,
    primary key (id)
);

create table users_roles
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password, email, score)
values
--        user user
('user', '$2y$12$KrzoIrtbd5clEOW8YchAMuZmwUuYLkuVJDw1Urh0Bf8QQqWBscmMK', 'user@gmail.com', 300),
--         admin    admin
('admin', '$2y$12$TfQDy9wG3yxrpFgOGL1OGuh4spwczrgfVTG9cJtz6nNmedZIOt0rm', 'admin@gmail.com', 250);

insert into users_roles (user_id, role_id)
VALUES (1, 1),
       (2, 2);

create table order_items
(
    id bigserial primary key,
    title varchar(255),
    quantity int,
    price_per_item  double precision,
    price double precision
);