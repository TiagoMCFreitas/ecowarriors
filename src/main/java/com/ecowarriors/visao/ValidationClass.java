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
        File fis = new File("./src/main/java/com/ecowarriors/images/logoEcoWarriorsTelas.png");
        
        Endereco endereco = new Endereco("Getulio vargas", "setor andreia", "goiania", "2929292", "viaduto");

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = null;
        
        data = new java.sql.Date(formatter.parse("10/11/2022").getTime());

//        Usuarios usuario = new Usuarios("7371727", "12345", "tiagoM", "tiago222@gmail.com", Usuario.GESTOR, "981555783");
//        IUsuarioDao usuarioDao = new UsuarioDao();
//        usuarioDao.cadastrarUsuarios(usuario);

        Denuncia denuncia = new Denuncia("", fis, "Tiago", endereco, "Comeram os mato tudo", Categoria.FLORA, data, "cabecinha");
        IDenunciaDao denunciaDAO = new DenunciaDao();
        denunciaDAO.cadastroDenuncia(denuncia);
    
    }
}
