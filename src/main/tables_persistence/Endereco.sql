create table Endereco(
	id serial primary key not null,
	protocolo_denuncia varchar,
	cep varchar not null,
	bairro varchar not null,
	rua varchar not null,
	municipio varchar not null,
	ponto_referencia varchar not null	
)