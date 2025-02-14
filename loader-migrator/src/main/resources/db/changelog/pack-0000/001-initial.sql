create table temp_schema.person
(
    id uuid not null,
    first_name jsonb not null,
    last_name jsonb not null,
    middle_name jsonb,
    age int not null
);

create unique index person_id_uindex
    on temp_schema.person (id);

alter table temp_schema.person
    add constraint person_pk
        primary key (id);

