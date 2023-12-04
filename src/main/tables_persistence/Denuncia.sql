create table Denuncia(
	id serial primary key not null,
	protocolo varchar ,
	foto bytea,
	denunciante varchar not null,
	descricao_Incidente varchar not null, 
	categoria varchar not null,
	data date,
	Autor_Crime varchar not null,
	status_Denuncia varchar
)