create table if not exists attendees (
    attendees_id serial primary key,
    attendees_name varchar(100) not null,
    email varchar(100) not null

);

create table if not exists venues(
    venue_id serial primary key,
    venue_name varchar(100) not null,
    location varchar(100) not null
);

create table if not exists events(
    event_id serial primary key,
    event_name varchar(100) not null,
    event_date timestamp,
    venue_id int not null,
    constraint fk_venue foreign key (venue_id) references venues (venue_id) on delete cascade on update cascade
);

create table if not exists event_attendee(
    event_id int not null,
    attendees_id int not null,
    primary key (event_id, attendees_id),
    constraint fk_event foreign key (event_id) references events (event_id) on delete cascade on update cascade,
    constraint fk_attendee foreign key (attendees_id) references attendees (attendees_id) on delete cascade on update cascade
);

drop table if exists event_attendee;


CREATE TABLE app_users
(
    user_id        serial PRIMARY KEY NOT NULL,
    full_name VARCHAR(50)        NOT NULL,
    email     VARCHAR(50)        NOT NULL,
    password  VARCHAR(255)       NOT NULL
);

CREATE TABLE app_roles
(
    role_id        serial PRIMARY KEY NOT NULL,
    name VARCHAR(50)        NOT NULL
);

CREATE TABLE user_role
(
    user_id INT NOT NULL REFERENCES app_users (user_id) ON DELETE CASCADE,
    role_id INT NOT NULL REFERENCES app_roles (role_id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);
