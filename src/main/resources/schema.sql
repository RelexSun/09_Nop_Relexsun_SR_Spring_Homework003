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
