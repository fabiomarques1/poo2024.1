use ufc;
#insert na tabela lutador
insert into lutador(nome, nacionalidade, idade, altura, peso)
values ("Henrique", "Brasileiro", 25, 1.86, 91.2);
insert into lutador(nome, nacionalidade, idade, altura, peso)
values ("Brian", "Inglês", 27, 1.79, 89.6);
select * from lutador;
#insert na tabela luta
insert into luta (data_hora, desafiado, desafiante, partidas)
values ("2024-09-12 18:30:00", 1, 2, 2);

select * from luta;

select * from lutador;

#Peso-Leve - 70
#Peso-Médio - 80
#Peso-Pesado - 100

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

select * from luta_lutador;