# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table item (
  id                            integer auto_increment not null,
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

drop table if exists item;

