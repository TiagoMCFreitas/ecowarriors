package com.ecowarriors.persistencia;

import com.ecowarriors.Enum.StatusDenuncia;
import com.ecowarriors.ferramentas.ConexaoBD;
import java.util.ArrayList;
import com.ecowarriors.modelos.Denuncia;
import com.ecowarriors.modelos.Endereco;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Base64;

import com.ecowarriors.services.Services;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Service;

public class DenunciaDao implements IDenunciaDao {

    private Connection conexao = null;
    PreparedStatement st, stEndereco;

    public DenunciaDao() throws Exception {
        conexao = ConexaoBD.getConexao();
    }

    @Override
    public void cadastroDenuncia(Denuncia denuncia, Endereco endereco) throws Exception {
        try {
            FileInputStream fis = new FileInputStream(denuncia.getFoto());

            stEndereco = conexao.prepareStatement("insert into Endereco(protocolo_denuncia, cep, bairro, rua, municipio, ponto_referencia) values (?, ?, ?, ?, ?, ?) RETURNING id");
            stEndereco.setString(1, "");
            stEndereco.setString(2, endereco.getCEP());
            stEndereco.setString(3, endereco.getBairro());
            stEndereco.setString(4, endereco.getRua());
            stEndereco.setString(5, endereco.getMunicipio());
            stEndereco.setString(6, endereco.getPontoReferencia());

            ResultSet generatedKeys = stEndereco.executeQuery();
            if (generatedKeys.next()) {
                int idEndereco = generatedKeys.getInt(1);
                System.out.println(idEndereco);
                st = conexao.prepareStatement("insert into Denuncia( protocolo, foto, denunciante, id_endereco, descricao_Incidente, categoria, data, Autor_Crime, status_denuncia) values (? ,?, ?, ?, ?, ?, ?, ?, ?) RETURNING id");
                st.setString(1, denuncia.getProtocolo());
                st.setBinaryStream(2, fis);
                st.setString(3, denuncia.getDenuciante());
                st.setInt(4, idEndereco);
                st.setString(5, denuncia.getDescricaoIncidente());
                st.setString(6, denuncia.getCategoria().toString());
                st.setDate(7, denuncia.getData());
                st.setString(8, denuncia.getAutorCrime());
                st.setString(9, denuncia.getStatusDenuncia().toString());
            }

            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                int idSerial = resultSet.getInt(1);
                int anoAtual = LocalDate.now().getYear();
                String protocolo = String.valueOf(idSerial) + "/" + anoAtual;
                System.out.println(protocolo);

                String update = "UPDATE Denuncia SET protocolo = ?  WHERE id = ?";
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

    public void atualizarProtocolo() {
        try {
            stEndereco = conexao.prepareStatement("UPDATE Endereco set protocolo_denuncia = Denuncia.protocolo \n"
                    + "from denuncia \n"
                    + "where id_endereco = endereco.id");
            stEndereco.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DenunciaDao.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            String sql = "update denuncia set status_denuncia = ? where denunciante = ?";
            PreparedStatement stUpdate = conexao.prepareStatement(sql);
            stUpdate.setString(1, StatusDenuncia.EM_PROCESSAMENTO.toString());
            stUpdate.setString(2, cpfDenunciante);
            stUpdate.executeUpdate();

            String sqlParaEmail = "select usuarios.nome , "
                    + "usuarios.email, "
                    + "denuncia.protocolo, "
                    + "denuncia.status_denuncia "
                    + "from denuncia "
                    + "inner join usuarios on usuarios.cpf = denunciante "
                    + "where usuarios.cpf = ? "
                    + "order by data_criacao desc";
            PreparedStatement stSearch = conexao.prepareStatement(sqlParaEmail);
            stSearch.setString(1, cpfDenunciante);
            ResultSet rs = stSearch.executeQuery();
            String emailUsuario = "";
            String protocolo = "";
            String status = "";
            String nome = "";
            while (rs.next()) {
                emailUsuario = rs.getString("email");
                protocolo = rs.getString("protocolo");
                status = rs.getString("status_denuncia");
                nome = rs.getString("nome");
            }
            Services service = new Services();
            String assunto = "Email referente ao protocolo: " + protocolo + "ECOWARRIORS";
            String mensagem = "Olá, " + nome + " essa mensagem é referente a denúncia que você enviou para nós,o status dela é: " + status;
            service.sendMail(emailUsuario, assunto, mensagem);

        } catch (Exception erro) {
            System.out.println("Erro no update de denuncia " + erro);
        }

    }

    public static void main(String[] args) {
        int anoAtual = LocalDate.now().getYear();
        System.out.println(anoAtual);
    }
}
