package com.ecowarriors.persistencia;

import com.ecowarriors.Enum.Usuario;
import com.ecowarriors.modelos.Usuarios;
import com.ecowarriors.ferramentas.ConexaoBD;
import org.postgresql.util.OSUtil;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class UsuarioDao implements IUsuarioDao {

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
            st.setString(2, Base64.getEncoder().encodeToString(usuario.getSenha().getBytes()));
            st.setString(3, usuario.getNome());
            st.setString(4, usuario.getEmail());
            st.setString(5, usuario.getTipoUsuario().toString());
            st.setString(6, usuario.getTelefone());
            st.executeUpdate();
            st.close();
        } catch (Exception erro) {
            System.out.println("Erro no cadastro de usuario " + erro);
        }

    }

    @Override
    public boolean logarUsuarios(String usuario, String senha) {
        try {
            String sql = "";
            if (usuario.contains("@")) {
                sql = "select * from usuarios where email = ?";
            } else {
                sql = "select * from usuarios where cpf = ?";
            }
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1, usuario);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String senhaCriptografada = rs.getString("senha");
                if (new String(Base64.getDecoder().decode(senhaCriptografada)).equals(senha)) {
                    return true;
                }
            }
            return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
