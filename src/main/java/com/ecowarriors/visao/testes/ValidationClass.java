package com.ecowarriors.visao.testes;

import com.ecowarriors.Enum.Categoria;
import com.ecowarriors.Enum.StatusDenuncia;
import com.ecowarriors.Enum.Usuario;
import com.ecowarriors.ferramentas.ConexaoBD;
import com.ecowarriors.modelos.Denuncia;
import com.ecowarriors.modelos.Endereco;
import com.ecowarriors.modelos.Usuarios;
import com.ecowarriors.persistencia.DenunciaDao;
import com.ecowarriors.persistencia.IDenunciaDao;
import com.ecowarriors.persistencia.IUsuarioDao;
import com.ecowarriors.persistencia.UsuarioDao;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ValidationClass {

    public static void main(String[] args) throws Exception {
       IDenunciaDao objetoDao = new DenunciaDao();
        System.out.println(objetoDao.respostaDenuncia("4/2023"));
//        denuncia.atualizarDenuncia(StatusDenuncia.EM_PROCESSAMENTO.toString(), "2/2023");
    }

}
