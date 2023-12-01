package com.ecowarriors.persistencia;

import com.ecowarriors.Enum.StatusDenuncia;
import com.ecowarriors.ferramentas.ConexaoBD;
import java.util.ArrayList;
import com.ecowarriors.modelos.Denuncia;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Base64;

import com.ecowarriors.services.Services;

import javax.mail.Service;

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

            st = conexao.prepareStatement("insert into Denuncia( protocolo, foto,denunciante, endereco_Incidente, descricao_Incidente, categoria, Autor_Crime,status_denuncia) values (?,?, ?, ?, ?, ?, ?, ?) RETURNING id");

            st.setString(1, denuncia.getProtocolo());
            st.setBinaryStream(2, fis);
            st.setString(3, denuncia.getDenuciante());
            st.setString(4, denuncia.getEnderecoIncidente().getCEP()+ " " + denuncia.getEnderecoIncidente().getBairro());
            st.setString(5, denuncia.getDescricaoIncidente());
            st.setString(6, denuncia.getCategoria().toString());
            st.setString(7, denuncia.getAutorCrime());
            st.setString(8, denuncia.getStatusDenuncia().toString());

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

    @Override
    public void atualizarDenuncia(String cpfDenunciante) throws Exception {
    try{
        String sql = "update denuncia set status_denuncia = ? where denunciante = ?";
            PreparedStatement stUpdate = conexao.prepareStatement(sql);
            stUpdate.setString(1, StatusDenuncia.EM_PROCESSAMENTO.toString());
            stUpdate.setString(2, cpfDenunciante);
            stUpdate.executeUpdate();



        String sqlParaEmail = "select usuarios.nome , " +
                "usuarios.email, " +
                "denuncia.protocolo, " +
                "denuncia.status_denuncia " +
                "from denuncia " +
                "inner join usuarios on usuarios.cpf = denunciante " +
                "where usuarios.cpf = ? " +
                "order by data_criacao desc";
        PreparedStatement stSearch = conexao.prepareStatement(sqlParaEmail);
        stSearch.setString(1, cpfDenunciante);
        ResultSet rs = stSearch.executeQuery();
        String emailUsuario = "";
        String protocolo = "";
        String status = "";
        String nome = "" ;
        while (rs.next()) {
            emailUsuario = rs.getString("email");
            protocolo = rs.getString("protocolo");
            status = rs.getString("status_denuncia");
            nome = rs.getString("nome");
        }
        Services service = new Services();
        String assunto = "Email referente ao protocolo: " + protocolo + "ECOWARRIORS";
        String mensagem = "Olá, " + nome + " essa mensagem é referente a denúncia que você enviou para nós,o status dela é: " + status;
        service.sendMail(emailUsuario,assunto,mensagem);

        } catch (Exception erro) {
            System.out.println("Erro no update de denuncia " + erro);
        }

    }



    public static void main(String[] args) {
        int anoAtual = LocalDate.now().getYear();
        System.out.println(anoAtual);
    }
}
