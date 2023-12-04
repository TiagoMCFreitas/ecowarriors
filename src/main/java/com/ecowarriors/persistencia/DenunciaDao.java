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

import com.ecowarriors.services.EmailService;

import java.util.List;

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

            st = conexao.prepareStatement("insert into denuncia( protocolo, foto, denunciante, descricao_Incidente, categoria, data, Autor_Crime, status_denuncia) values (? ,?, ?, ?, ?, ?, ?, ?) RETURNING id, protocolo");
            st.setString(1, denuncia.getProtocolo());
            st.setBinaryStream(2, fis);
            st.setString(3, denuncia.getDenuciante());
            st.setString(4, denuncia.getDescricaoIncidente());
            st.setString(5, denuncia.getCategoria().toString());
            st.setDate(6, denuncia.getData());
            st.setString(7, denuncia.getAutorCrime());
            st.setString(8, denuncia.getStatusDenuncia().toString());

            ResultSet generatedKeys = st.executeQuery();

            if (generatedKeys.next()) {
                int idSerial = generatedKeys.getInt(1);
                int anoAtual = LocalDate.now().getYear();
                String protocolo = String.valueOf(idSerial) + "/" + anoAtual;
                System.out.println(protocolo);

                String update = "UPDATE Denuncia SET protocolo = ?  WHERE id = ?";
                try ( PreparedStatement stUpdate = conexao.prepareStatement(update)) {
                    stUpdate.setString(1, protocolo);
                    stUpdate.setInt(2, idSerial);
                    stUpdate.executeUpdate();

                }
                String sqlParaEmail = "select usuarios.nome , " +
                        "usuarios.email, " +
                        "denuncia.protocolo, " +
                        "denuncia.status_denuncia " +
                        "from denuncia " +
                        "inner join usuarios on usuarios.cpf = denunciante " +
                        "where denuncia.protocolo = ? " +
                        "order by data_criacao desc";
                PreparedStatement stSearch = conexao.prepareStatement(sqlParaEmail);
                stSearch.setString(1, protocolo);
                ResultSet rs = stSearch.executeQuery();
                String emailUsuario = "";
                String status = "";
                String nome = "" ;
                while (rs.next()) {
                    emailUsuario = rs.getString("email");
                    status = rs.getString("status_denuncia");
                    nome = rs.getString("nome");
                }
                EmailService service = new EmailService();
                String assunto = "Email referente ao protocolo: " + protocolo + " ECOWARRIORS";
                String mensagem = "Olá, " + nome + " essa mensagem é referente a denúncia que você enviou para nós,o status dela é: " + formatarDenuncia(status);
                service.sendMail(denuncia.getDenuciante(),assunto,mensagem);

                stEndereco = conexao.prepareStatement("insert into Endereco(protocolo_denuncia, cep, bairro, rua, municipio, ponto_referencia) values (?, ?, ?, ?, ?, ?) RETURNING id");
                stEndereco.setString(1, protocolo);
                stEndereco.setString(2, endereco.getCEP());
                stEndereco.setString(3, endereco.getBairro());
                stEndereco.setString(4, endereco.getRua());
                stEndereco.setString(5, endereco.getMunicipio());
                stEndereco.setString(6, endereco.getPontoReferencia());
                stEndereco.executeUpdate();
            }
        } catch (Exception erro) {
            System.out.println(erro);
        }
    }

    @Override
    public void consultarDenuncia(Denuncia denuncia) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'consultarDenuncia'");
    }

    @Override
    public List<Denuncia> listagemDenuncia() throws Exception {
        List<Denuncia> denuncias = new ArrayList<>();

            String sql = "SELECT id, protocolo, denunciante FROM Denuncia";
            try ( PreparedStatement ps = conexao.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Denuncia DenunciaLista = new Denuncia();
                    DenunciaLista.setId(rs.getInt("id"));
                    DenunciaLista.setProtocolo(rs.getString("protocolo"));
                    DenunciaLista.setDenuciante(rs.getString("denunciante"));                  
                    denuncias.add(DenunciaLista);
                }
            }
        

        return denuncias;
    }

    @Override
    public void atualizarDenuncia(String statusDenuncia, String protocolo) throws Exception {
    try{
        String sql = "update denuncia set status_denuncia = ? where protocolo = ?";
            PreparedStatement stUpdate = conexao.prepareStatement(sql);
            stUpdate.setString(1, statusDenuncia);
            stUpdate.setString(2, protocolo);
            stUpdate.executeUpdate();



            String sqlParaEmail = "select usuarios.nome , " +
                    "usuarios.email, " +
                    "denuncia.protocolo, " +
                    "denuncia.status_denuncia " +
                    "from denuncia " +
                    "inner join usuarios on usuarios.cpf = denunciante " +
                    "where denuncia.protocolo = ? " +
                    "order by data_criacao desc";
        PreparedStatement stSearch = conexao.prepareStatement(sqlParaEmail);
        stSearch.setString(1, protocolo);
        ResultSet rs = stSearch.executeQuery();
        String emailUsuario = "";
        String status = "";
        String nome = "" ;
        while (rs.next()) {
            emailUsuario = rs.getString("email");
            status = rs.getString("status_denuncia");
            nome = rs.getString("nome");
        }
        EmailService service = new EmailService();
        String assunto = "Email referente ao protocolo: " + protocolo + " ECOWARRIORS";
        String mensagem = "Olá, " + nome + " essa mensagem é referente a denúncia que você enviou para nós,o status dela é: " + formatarDenuncia(status);
        service.sendMail(emailUsuario,assunto,mensagem);

        } catch (Exception erro) {
            System.out.println("Erro no update de denuncia " + erro);
        }

    }

    @Override
    public String formatarDenuncia(String status) throws Exception {
        if(status.equals(StatusDenuncia.CRIADA.toString())){
            return "Criada";
        }
        else if (status.equals(StatusDenuncia.RESPONDIDA.toString())){
            return "Respondida";
        }
        else if (status.equals(StatusDenuncia.EM_PROCESSAMENTO.toString())){
            return "Em processamento";
        }
    return null;
    }


    public static void main(String[] args) {
        int anoAtual = LocalDate.now().getYear();
        System.out.println(anoAtual);
    }


}
