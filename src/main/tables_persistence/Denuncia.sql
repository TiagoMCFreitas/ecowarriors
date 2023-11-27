create table Denuncia(
	id serial primary key not null,
	protocolo varchar,
	foto bytea,
	denunciante varchar not null,
	endereco_Incidente varchar not null,
	descricao_Incidente varchar not null, 
	categoria varchar not null,
	data date not null,
	Autor_Crime varchar not null
)