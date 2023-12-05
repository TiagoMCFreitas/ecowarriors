    package com.ecowarriors.persistencia;

import com.ecowarriors.Enum.Categoria;
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
import java.io.File;
import java.util.Date;

import java.util.List;

public class DenunciaDao implements IDenunciaDao {

    private Connection conexao = null;
    PreparedStatement st, stEndereco, stImagem;

    public DenunciaDao() throws Exception {
        conexao = ConexaoBD.getConexao();
    }

    @Override
    public void cadastroDenuncia(Denuncia denuncia, Endereco endereco) throws Exception {
        try {
            FileInputStream fis = new FileInputStream(denuncia.getFoto());

            st = conexao.prepareStatement("insert into denuncia( protocolo, denunciante, descricao_Incidente, categoria, data, Autor_Crime, status_denuncia) values (? ,?, ?, ?, ?, ?, ?) RETURNING id, protocolo");
            st.setString(1, denuncia.getProtocolo());
            st.setString(2, denuncia.getDenuciante());
            st.setString(3, denuncia.getDescricaoIncidente());
            st.setString(4, denuncia.getCategoria().toString());
            st.setDate(5, denuncia.getData());
            st.setString(6, denuncia.getAutorCrime());
            st.setString(7, denuncia.getStatusDenuncia().toString());

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
                        "where denuncia.protocolo = ? ";
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
                
                System.out.println(emailUsuario);
                EmailService service = new EmailService();
                String assunto = "Email referente ao protocolo: " + protocolo + " ECOWARRIORS";
                String mensagem = "Olá, " + nome + " essa mensagem é referente a denúncia que você enviou para nós,o status dela é: " + formatarDenuncia(status);
                service.sendMail(emailUsuario,assunto,mensagem);

                stEndereco = conexao.prepareStatement("insert into Endereco(protocolo_denuncia, cep, bairro, rua, municipio, ponto_referencia) values (?, ?, ?, ?, ?, ?)");
                stEndereco.setString(1, protocolo);
                stEndereco.setString(2, endereco.getCEP());
                stEndereco.setString(3, endereco.getBairro());
                stEndereco.setString(4, endereco.getRua());
                stEndereco.setString(5, endereco.getMunicipio());
                stEndereco.setString(6, endereco.getPontoReferencia());
                stEndereco.executeUpdate();
                
                String pastaProtocolo = protocolo.replace("/","-");
                String caminhoDaPasta = "./src/main/java/com/ecowarriors/pasta_protocolo/"+pastaProtocolo;
                File pasta =  new File(caminhoDaPasta);
                File[] arquivos = pasta.listFiles();
                System.out.println(caminhoDaPasta);
                for(File arquivo :  arquivos){
                String arquivoPasta = caminhoDaPasta +"/"+arquivo.getName();
                System.out.println(arquivo.getName());
                stImagem = conexao.prepareStatement("insert into imagens (hash_imagem,caminho_imagem,id_protocolo)values(?,?,?)");
                stImagem.setString(1, arquivo.getName());
                stImagem.setString(2,arquivoPasta);
                stImagem.setString(3, protocolo);
                stImagem.executeUpdate();
                }
                
                
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
    public List<Denuncia> listagemDenunciaOrdernada() throws Exception {
        List<Denuncia> denuncias = new ArrayList<>();

            String sql = "SELECT id, protocolo, denunciante FROM Denuncia order by protocolo desc";
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
                    "inner join usuarios on usuarios.cpf = denuncia.denunciante " +
                    "where denuncia.protocolo = ?";
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
        System.out.println(emailUsuario);
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

    @Override
    public List<Denuncia> tabelaDenunciasUsuarios(String cpf) throws Exception {
        try {
            List<Denuncia> denuncias = new ArrayList<>();

            String sql = "SELECT protocolo, denunciante,status_denuncia FROM Denuncia where denunciante = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);  
                    ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery(); 
                while (rs.next()) {
                    Denuncia DenunciaLista = new Denuncia();
                    DenunciaLista.setProtocolo(rs.getString("protocolo"));
                    DenunciaLista.setDenuciante(rs.getString("denunciante"));                  
                    DenunciaLista.setStatusDenuncia(StatusDenuncia.valueOf(rs.getString("status_denuncia")));
                    denuncias.add(DenunciaLista);
                }
                System.out.println(denuncias.get(0));
            return denuncias;
    }catch(Exception e){
            System.out.println(e);
    }
        return null;
}

    @Override
    public  String[]respostaDenuncia(String protocolo) throws Exception {
        try {
            String []listaDeParametros = new String[9];
            String sql = "select endereco.*, \n" +
                        "	denuncia.* \n" +
                        "	from denuncia \n" +
                        "	inner join endereco on endereco.protocolo_denuncia = denuncia.protocolo \n" +
                        "	where denuncia.protocolo =?";
            PreparedStatement stUpdate = conexao.prepareStatement(sql);
            stUpdate.setString(1, protocolo);
            ResultSet rs = stUpdate.executeQuery(); 

            while (rs.next()) {
                
    listaDeParametros[0] = rs.getString("cep");
    listaDeParametros[1] = rs.getString("bairro");
    listaDeParametros[2] = rs.getString("rua");
    listaDeParametros[3] = rs.getString("municipio");
    listaDeParametros[4] = rs.getString("ponto_referencia");
    listaDeParametros[5] = Categoria.valueOf(rs.getString("categoria")).toString();
    listaDeParametros[6] = rs.getString("descricao_incidente");
    listaDeParametros[7] = rs.getString("avaliacao_gestor");
    listaDeParametros[8] = rs.getDate("data").toString();

    // Imprime os valores do CEP para verificar
}

            
            return listaDeParametros;
            
    }catch(Exception e){
            System.out.println(e);
    }
        return null;
}
}


