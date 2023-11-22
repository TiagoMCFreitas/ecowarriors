package com.ecowarriors.persistencia;

import com.ecowarriors.ferramentas.ConexaoBD;
import java.util.ArrayList;
import com.ecowarriors.modelos.Denuncia;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class DenunciaDao implements IDenunciaDao {

    private Connection conexao = null;
    PreparedStatement st;

    public DenunciaDao() throws Exception {
        conexao = ConexaoBD.getConexao();
    }

    @Override
    public void cadastroDenuncia(Denuncia denuncia) throws Exception {
        try {
            FileInputStream fis = new FileInputStream(denuncia.getFoto());

            st = conexao.prepareStatement("insert into Denuncia( foto, denunciante, enderecoIncidente, descricaoIncidente, categoria, data, AutorCrime) values (?, ?, ?, ?, ?, ?, ?) RETURNING ID");
            st.setBinaryStream(1, fis);
            st.setString(2, denuncia.getDenuciante());
            st.setString(3, denuncia.getEndereco().getId());
            st.setString(4, denuncia.getDescricao());
            st.setString(5, denuncia.getCategoria().toString());
            st.setDate(6, denuncia.getData());
            st.setString(7, denuncia.getAutorCrime());
            st.executeUpdate();
            st.close();
            
        }catch(Exception erro){
            System.out.println("Erro no cadastro de denuncia " + erro);
        }
    }
            @Override
            public void consultarDenuncia
            (Denuncia denuncia) throws Exception {
                throw new UnsupportedOperationException("Unimplemented method 'consultarDenuncia'");
            }

            @Override
            public ArrayList<Denuncia> listagemDenuncia() throws Exception {
                throw new UnsupportedOperationException("Unimplemented method 'listagemDenuncia'");
            }
    
    

    public static void main(String[] args) {
        int anoAtual = LocalDate.now().getYear();
        System.out.println(anoAtual);
    }
}
