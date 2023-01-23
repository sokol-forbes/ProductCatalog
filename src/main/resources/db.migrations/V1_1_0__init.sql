create sequence hibernate_sequence start 1 increment 1;
create table product
(
    id                  int8 not null,
    is_deleted          boolean default false,
    description         varchar(255),
    name                varchar(255),
    price               float8,
    remark_general      varchar(255),
    remark_special      varchar(255),
    product_category_id int8,
    primary key (id)
);
create table product_category
(
    id         int8 not null,
    is_deleted boolean default false,
    name       varchar(255),
    primary key (id)
);
create table usr
(
    id         int8 not null,
    is_deleted boolean default false,
    password   varchar(255),
    role       int4,
    username   varchar(255),
    primary key (id)
);
alter table product
    add constraint FKcwclrqu392y86y0pmyrsi649r foreign key (product_category_id) references product_category