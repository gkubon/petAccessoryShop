# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table farmer (
  id                            bigint auto_increment not null,
  email                         varchar(255),
  password                      varchar(255),
  name                          varchar(255),
  wepay_access_token            varchar(255),
  wepay_account_id              bigint,
  constraint pk_farmer primary key (id)
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

drop table if exists farmer;

drop table if exists item;

