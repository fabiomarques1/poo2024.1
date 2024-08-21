drop database if exists cadastro;
create database cadastro;
use cadastro;

create table pessoa(
codigo int auto_increment primary key,
nome varchar(50),
data_nascimento date
);

