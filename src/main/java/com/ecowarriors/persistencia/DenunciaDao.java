package com.ecowarriors.persistencia;

import com.ecowarriors.ferramentas.ConexaoBD;
import java.util.ArrayList;
import com.ecowarriors.modelos.Denuncia;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

            st = conexao.prepareStatement("insert into Denuncia( protocolo, foto, denunciante, endereco_Incidente, descricao_Incidente, categoria, data, Autor_Crime) values (?, ?, ?, ?, ?, ?, ?, ?) RETURNING id");

            st.setString(1, denuncia.getProtocolo());
            st.setBinaryStream(2, fis);
            st.setString(3, denuncia.getDenuciante());
            st.setString(4, denuncia.getEnderecoIncidente().getCEP()+ " " + denuncia.getEnderecoIncidente().getBairro());
            st.setString(5, denuncia.getDescricaoIncidente());
            st.setString(6, denuncia.getCategoria().toString());
            st.setDate(7, denuncia.getData());
            st.setString(8, denuncia.getAutorCrime());

            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                int idSerial = resultSet.getInt(1);
                int anoAtual = LocalDate.now().getYear();
                String protocolo = String.valueOf(idSerial) + "/" + anoAtual;
                System.out.println(idSerial);

                String update = "UPDATE Denuncia SET protocolo = ? WHERE id = ?";
                try ( PreparedStatement stUpdate = conexao.prepareStatement(update)) {
                    stUpdate.setString(1, protocolo);
                    stUpdate.setInt(2, idSerial);
                    stUpdate.executeUpdate();

                } catch (Exception erro) {
                    System.out.println("Erro no cadastro de denuncia " + erro);
                }
                st.close();
            }
        } catch (Exception erro) {
            System.out.println("Erro no cadastro de denuncia " + erro);
        }

    }

    @Override
    public void consultarDenuncia(Denuncia denuncia) throws Exception {
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
