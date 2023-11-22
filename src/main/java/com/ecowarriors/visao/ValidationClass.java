package com.ecowarriors.visao;

import com.ecowarriors.Enum.Usuario;
import com.ecowarriors.modelos.Usuarios;
import com.ecowarriors.persistencia.IUsuarioDao;
import com.ecowarriors.persistencia.UsuarioDao;

public class ValidationClass {
    public static void main(String[] args) throws Exception {
        Usuarios usuario = new Usuarios("81723123","12345","tiagoM","tiagoM@gmail.com", Usuario.GESTOR,"981555783");
        IUsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.cadastrarUsuarios(usuario);
    }
}
