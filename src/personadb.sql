create database personas;
use personas;

create table persona(
    id int not null auto_increment,
    nombre varchar(30) not null,
    edad int not null,
    constraint PK_id primary key (id)
);