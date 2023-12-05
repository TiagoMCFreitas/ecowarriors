create table Denuncia(
	id serial primary key not null,
	protocolo varchar,
	denunciante varchar not null,
	descricao_Incidente varchar not null,
	avaliacao_gestor varchar,
	categoria varchar not null,
	data date,
	Autor_Crime varchar not null,
	status_Denuncia varchar
)
