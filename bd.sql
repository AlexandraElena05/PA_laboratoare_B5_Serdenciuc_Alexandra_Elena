
create table genres(
    id integer generated always as identity (start with 1 increment by 1) not null,
    name varchar2(100) not null,
    constraint "pk1" primary key (id)
)
    /

create table movies(
    id integer generated always as identity (start with 1 increment by 1) not null,
    title varchar2(100) not null,
    film_id integer not null,
    release_date integer not null,
    duration integer not null,
    score integer not null,
    constraint "fk1" foreign key (film_id) references genres on delete cascade,
    constraint "pk2" primary key (id)
)
    /

create table movie_genres(
    movie_id integer not null,
    genre_id integer not null,
    constraint "fk2" foreign key (movie_id) references movies(id) on delete cascade,
    constraint "fk3" foreign key (genre_id) references genres(id) on delete cascade,
    constraint "pk3" primary key (movie_id, genre_id)
)
    /
commit;


select * from genres;