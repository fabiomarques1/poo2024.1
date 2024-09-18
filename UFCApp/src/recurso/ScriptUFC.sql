drop database if exists ufc;
create database ufc;
use ufc;
create table lutador(
codigo int auto_increment primary key,
nome varchar(100),
nacionalidade varchar(100),
idade int,
altura decimal(3,2),
peso decimal(3,1),
vitorias int default 0,
derrotas int default 0,
empates int default 0
);

create table luta (
codigo int auto_increment primary key,
data_hora datetime,
desafiado int,
foreign key (desafiado) references lutador(codigo),
desafiante int,
foreign key (desafiante) references lutador(codigo),
partidas int,
aprovada boolean default false
);

create view luta_lutador as
SELECT la.codigo as cod_luta,
       la.data_hora, 
       dso.codigo as cod_dso,
       dso.nome as nome_dso,
       dso.nacionalidade as nacionalidade_dso,
       dso.idade as idade_dso,
       dso.altura as altura_dso,
       dso.peso as peso_dso,
       dso.vitorias as vitorias_dso,
       dso.derrotas as derrotas_dso,
       dso.empates as empates_dso,
       dft.codigo as cod_dft,
       dft.nome as nome_dft,
       dft.nacionalidade as nacionalidade_dft,
       dft.idade as idade_dft,
       dft.altura as altura_dft,
       dft.peso as peso_dft,
       dft.vitorias as vitorias_dft,
       dft.derrotas as derrotas_dft,
       dft.empates as empates_dft,
       la.partidas, 
       la.aprovada
FROM luta la
inner JOIN lutador dso ON (la.desafiado = dso.codigo)
inner JOIN lutador dft ON (la.desafiante = dft.codigo);