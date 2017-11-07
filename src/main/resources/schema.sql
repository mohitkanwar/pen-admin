drop table BOOKINGS if exists;
create table BOOKINGS(ID serial, FIRST_NAME varchar(5) NOT NULL);

drop table USER if exists;
create table USER(ID serial, FIRST_NAME varchar(20) NOT NULL, LAST_NAME varchar(40));