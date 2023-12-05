create table imagens(
	id serial primary key not null,
	hash_imagem varchar not null,
	caminho_imagem varchar not null,
	id_protocolo varchar not null
	)