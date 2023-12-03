package com.ecowarriors.persistencia;

import java.util.ArrayList;
import com.ecowarriors.modelos.Denuncia;
import com.ecowarriors.modelos.Endereco;
import java.util.List;

public interface IDenunciaDao {
    void cadastroDenuncia(Denuncia denuncia, Endereco endereco) throws Exception;
    void consultarDenuncia(Denuncia denuncia) throws Exception;
    ArrayList<Denuncia> listagemDenuncia() throws Exception;
    void atualizarDenuncia(String cpfDenunciante)throws Exception;
    List<Denuncia> obterDenuncias() throws Exception;
}
