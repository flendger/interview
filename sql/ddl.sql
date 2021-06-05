use interview;

drop table if exists durations;
create table durations
(
    id      int auto_increment primary key,
    minutes int not null default 0
);
insert into durations (minutes)
values (60),
       (90),
       (120),
       (180);

drop table if exists movies;
create table movies
(
    id          int auto_increment primary key,
    title       varchar(255) not null,
    duration_id int          not null references durations (id)
);
insert into movies (title, duration_id)
values ('movie_1', 1),
       ('movie_2', 2),
       ('movie_3', 2),
       ('movie_4', 3),
       ('movie_5', 4);

drop table if exists movie_sessions;
create table movie_sessions
(
    id         int auto_increment primary key,
    movie_id   int   not null references movies (id),
    start_time time  not null,
    price      float not null default 0
);
insert into movie_sessions (movie_id, start_time, price) VALUES
(1, '12:00:00', 100),
(2, '13:00:00', 120),
(3, '14:00:00', 130),
(4, '16:00:00', 200),
(5, '18:00:00', 500);