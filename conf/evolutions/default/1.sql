# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cart (
  id                            bigint auto_increment not null,
  items                         varchar(255),
  constraint pk_cart primary key (id)
);

create table farmer (
  id                            bigint auto_increment not null,
  email                         varchar(255),
  password                      varchar(255),
  name                          varchar(255),
  wepay_access_token            varchar(255),
  wepay_account_id              bigint,
  constraint pk_farmer primary key (id)
);

create table inventory_item (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  price                         double,
  quantity                      integer,
  img_path                      varchar(255),
  constraint pk_inventory_item primary key (id)
);

create table item (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  price                         double,
  categorie                     varchar(255),
  description                   varchar(255),
  quantity                      integer,
  color                         varchar(255),
  picture                       varchar(255),
  constraint pk_item primary key (id)
);


# --- !Downs

drop table if exists cart;

drop table if exists farmer;

drop table if exists inventory_item;

drop table if exists item;

