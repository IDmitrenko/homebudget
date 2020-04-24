/*
 Создание функции для uuid с консоли БД
 CREATE EXTENSION "uuid-ossp"
*/
CREATE SCHEMA IF NOT EXISTS public;

DROP TABLE IF EXISTS type_income;

create table type_income
(
    id   uuid default uuid_generate_v4() not null
        constraint typeincome_pk
            primary key,
    name varchar(256)                    not null
);

comment on table type_income is 'Типы прихода';

alter table type_income
    owner to postgres;

create unique index typeincome_id_uindex
    on type_income (id);

create unique index typeincome_name_uindex
    on type_income (name);

INSERT INTO type_income (id, name) VALUES ('9a1a9d33-674f-467c-9cdc-f9d9fd9e4b9d', 'Заработная плата');
INSERT INTO type_income (id, name) VALUES ('7f416f98-8530-405f-a0b7-dc2675a531ee', 'Проценты по вкладам');
INSERT INTO type_income (id, name) VALUES ('03e07206-9404-4ee9-9e5c-daab758d5760', 'Пенсия');
INSERT INTO type_income (id, name) VALUES ('4bda8523-d189-497c-bbd7-0ebc6e7e01db', 'Социальные пособия');
INSERT INTO type_income (id, name) VALUES ('520f4495-a0a5-4bdf-a0ac-cbd89de0c8db', 'Подработки');

DROP TABLE IF EXISTS type_expense;

create table type_expense
(
    id   uuid default uuid_generate_v4() not null
        constraint type_expense_pk
            primary key,
    name varchar(256)                    not null
);

comment on table type_expense is 'Типы расхода';

alter table type_expense
    owner to postgres;

create unique index type_expense_id_uindex
    on type_expense (id);

create unique index type_expense_name_uindex
    on type_expense (name);

INSERT INTO type_expense (id, name) VALUES ('cc5a78cb-7229-4f34-a3f3-6e352be0c26e', 'Коммунальные расходы');
INSERT INTO type_expense (id, name) VALUES ('beacf5cf-433d-4ca9-996f-0e33567f4dda', 'Личные расходы');
INSERT INTO type_expense (id, name) VALUES ('d80dca7f-3985-4a0f-97ae-18d5427daa19', 'Медицинское обслуживание');
INSERT INTO type_expense (id, name) VALUES ('45a8ab1d-606c-471a-89e2-f300b3d07bd8', 'Одежда и обувь');
INSERT INTO type_expense (id, name) VALUES ('97ddd281-380a-4ba4-a1c2-8a8c6268706d', 'Подарки');
INSERT INTO type_expense (id, name) VALUES ('77a050df-fdd1-41d0-84a9-09e11ca580b9', 'Продукты');
INSERT INTO type_expense (id, name) VALUES ('f846d313-acfc-4236-a863-89ff0ad3a93c', 'Развлечения');
INSERT INTO type_expense (id, name) VALUES ('022353b7-04aa-4529-92a2-5f43a06e491b', 'Расходы на детей');
INSERT INTO type_expense (id, name) VALUES ('0e6271bb-0bce-49fe-842c-ecb49398dc58', 'Траты на машину');

DROP TABLE IF EXISTS remains;

create table remains
(
    id     uuid default uuid_generate_v4() not null
        constraint remains_pk
            primary key,
    date   date                            not null,
    amount double precision                not null
);

comment on table remains is 'Остаток';

alter table remains
    owner to postgres;

create unique index remains_date_uindex
    on remains (date);

create unique index remains_id_uindex
    on remains (id);

DROP TABLE IF EXISTS participant;

create table participant
(
    id        uuid default uuid_generate_v4() not null
        constraint participant_pk
            primary key,
    login     varchar(255)                    not null,
    password  varchar(255)                    not null,
    first_name varchar(255)                   not null,
    last_name  varchar(255),
    email     varchar(255)                    not null,
	role      varchar(255)                    not null
);

comment on table participant is 'участник';

alter table participant
    owner to postgres;

create unique index participant_email_uindex
    on participant (email);

create unique index participant_id_uindex
    on participant (id);

create unique index participant_login_uindex
    on participant (login);
/*
пароль admin
 */
INSERT INTO participant (id, login, password, first_name, last_name, email, role) VALUES ('c7249965-96a5-4c7d-95bc-2d1de3a04d24', 'Olga', '$2a$08$CbyfvmXvZdXJFY0A2Xmbz.mGXP/z/BfRNpS3wWLVR2CSRiIlBwMsK', 'Ольга', 'Дмитренко', 'Dmitrenko.Olga@yandex.ru', 'ROLE_CUSTOMER');
INSERT INTO participant (id, login, password, first_name, last_name, email, role) VALUES ('25dd3ad6-d829-4012-9ae0-428fbbb1f6c0', 'Dias', '$2a$08$ALSCD..CwoFIplqLOmxf6eyQ.yIE.zwFoIvB5wBSqK6IAkGSSpSGS', 'Игорь', 'Дмитренко', 'Dias64@mail.ru', 'ROLE_ADMIN');
INSERT INTO participant (id, login, password, first_name, last_name, email, role) VALUES ('234e4907-afda-4ca3-9e1f-5883c26609b6', 'anonymous', '$2a$08$Tr9q0XmfnIPFWg9GrYJVoOTeG.yTYPCHn9.OdCW2QW1QZwCUFGhJi', 'anonymous', 'anonymous', 'anonymous@yandex.ru', 'ROLE_CUSTOMER');

DROP TABLE IF EXISTS long_term_goal;

create table long_term_goal
(
    id             uuid default uuid_generate_v4() not null
        constraint long_term_goal_pk
            primary key,
    name           varchar(256)                    not null,
    estimated_cost double precision                not null,
    date_start     date                            not null,
    date_end       date,
    monthly_amount double precision                not null
);

comment on table long_term_goal is 'Долгосрочные цели';

alter table long_term_goal
    owner to postgres;

create unique index long_term_goal_id_uindex
    on long_term_goal (id);

DROP TABLE IF EXISTS income;

create table income
(
    id             uuid default uuid_generate_v4() not null
        constraint income_pk
            primary key,
    date           date                            not null,
    amount         double precision                not null,
    participant_id uuid                            not null
        constraint "FK_income_participant"
            references participant
            on update cascade on delete cascade,
    type_income_id uuid                            not null
        constraint "FK_income_type_income"
            references type_income
            on update cascade on delete cascade
);

comment on table income is 'Поступления';

alter table income
    owner to postgres;

create unique index income_id_uindex
    on income (id);

DROP TABLE IF EXISTS expense;

create table expense
(
    id                uuid default uuid_generate_v4() not null
        constraint expense_pk
            primary key,
    type_expense_id   uuid                            not null
        constraint "FK_expense_type_expense"
            references type_expense
            on update cascade on delete cascade,
    participant_id    uuid                            not null
        constraint "FK_expense_participant"
            references participant
            on update cascade on delete cascade,
    date              date                            not null,
    amount            double precision                not null,
    comment           varchar(256),
    long_term_goal_id uuid
        constraint "FK_expense_long_term_goal"
            references long_term_goal
);

comment on table expense is 'Расход';

alter table expense
    owner to postgres;

create unique index expense_id_uindex
    on expense (id);
