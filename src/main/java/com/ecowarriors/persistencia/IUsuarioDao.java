package com.ecowarriors.persistencia;

import com.ecowarriors.modelos.Usuarios;

public interface IUsuarioDao {
     void cadastrarUsuarios(Usuarios usuario);
     boolean logarUsuarios(String cpf, String senha);
}
