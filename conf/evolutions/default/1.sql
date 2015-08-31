# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table actor (
  id                        bigint auto_increment not null,
  name                      varchar(30) not null,
  height                    integer,
  blood                     varchar(255),
  birthday                  timestamp,
  birthplace_id             integer,
  update_at                 timestamp not null,
  constraint pk_actor primary key (id))
;

create table prefecture (
  id                        integer not null,
  name                      varchar(6) not null,
  constraint pk_prefecture primary key (id))
;

create sequence prefecture_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists actor;

drop table if exists prefecture;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists prefecture_seq;

