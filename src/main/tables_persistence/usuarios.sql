create table usuarios(
	id bigserial primary key not null,
	cpf varchar unique not null,
	senha varchar not null,
	nome varchar not null,
	email varchar unique not null,
	tipo_do_usuario varchar not null,
	telefone varchar not null
)