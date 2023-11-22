package com.ecowarriors.persistencia;

import com.ecowarriors.modelos.Usuarios;
import com.ecowarriors.ferramentas.ConexaoBD;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class UsuarioDao implements IUsuarioDao{
    private Connection conexao = null;
    PreparedStatement st;
    public UsuarioDao() throws Exception {
        conexao = ConexaoBD.getConexao();

    }

    @Override
    public void cadastrarUsuarios(Usuarios usuario) {
        try {

            st = conexao.prepareStatement("insert into usuarios( cpf, senha, nome, email, tipo_do_usuario, telefone) values (?, ?, ?, ?, ?, ?) ");
            st.setString(1, usuario.getCpf());
            st.setString(2, usuario.getSenha());
            st.setString(3, usuario.getNome());
            st.setString(4, usuario.getEmail());
            st.setString(5, usuario.getTipoUsuario().toString());
            st.setString(6,usuario.getTelefone());
            st.executeUpdate();
            st.close();
        }catch(Exception erro){
            System.out.println("Erro no cadastro de usuario " + erro);
        }


    }
}
