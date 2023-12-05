package com.ecowarriors.persistencia;

import com.ecowarriors.modelos.Usuarios;

public interface IUsuarioDao {
     void cadastrarUsuarios(Usuarios usuario);
     String logarUsuarios(String cpf, String senha);
}
