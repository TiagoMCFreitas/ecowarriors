package com.ecowarriors.persistencia;

import java.util.ArrayList;
import com.ecowarriors.modelos.Denuncia;
import com.ecowarriors.modelos.Endereco;

public interface IDenunciaDao {
    void cadastroDenuncia(Denuncia denuncia, Endereco endereco) throws Exception;
    void consultarDenuncia(Denuncia denuncia) throws Exception;
    ArrayList<Denuncia> listagemDenuncia() throws Exception;
    void atualizarProtocolo() throws Exception;
    void atualizarDenuncia(String cpfDenunciante)throws Exception;
}
