package com.ecowarriors.visao;

import com.ecowarriors.Enum.Categoria;
import com.ecowarriors.Enum.Usuario;
import com.ecowarriors.modelos.Denuncia;
import com.ecowarriors.modelos.Endereco;
import com.ecowarriors.modelos.Usuarios;
import com.ecowarriors.persistencia.DenunciaDao;
import com.ecowarriors.persistencia.IDenunciaDao;
import com.ecowarriors.persistencia.IUsuarioDao;
import com.ecowarriors.persistencia.UsuarioDao;
import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ValidationClass {

    public static void main(String[] args) throws Exception {
       IUsuarioDao usuarioDao = new UsuarioDao();
       usuarioDao.logarUsuarios("705.594.041-90","123455");


    }
}
