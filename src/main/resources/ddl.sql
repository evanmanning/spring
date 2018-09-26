drop table if exists reservation cascade;
drop table if exists person cascade;
drop table if exists phone_number cascade;
drop table if exists flight cascade;
drop table if exists reservation_person cascade;
drop table if exists reservation_flight cascade;
drop table if exists time cascade;

drop table if exists time cascade;

create table reservation (
  id serial primary key,
  confirmation_code varchar(255)
);

create table person (
  id serial primary key,
  surname varchar(255),
  given_name varchar(255),
  birth_date date
);

create table phone_number (
  id serial primary key,
  country_code varchar(10),
  number varchar(50),
  person_id integer references person(id)
);

create table flight (
  id serial primary key,
  origin varchar(255),
  destination varchar(255),
  departure_time timestamp with time zone,
  arrival_time timestamp with time zone
);

create table reservation_person (
  reservation_id integer references reservation(id),
  person_id integer references person(id)
);

create table reservation_flight (
  reservation_id integer references reservation(id),
  flight_id integer references flight(id)
);

create table time (
  id serial primary key,
  ts_with_tz timestamp with time zone,
  ts_without_tz timestamp without time zone
);