package com.ecowarriors.persistencia;

import java.util.ArrayList;

import com.ecowarriors.Enum.StatusDenuncia;
import com.ecowarriors.modelos.Denuncia;
import com.ecowarriors.modelos.Endereco;
import java.util.List;

public interface IDenunciaDao {
    void cadastroDenuncia(Denuncia denuncia, Endereco endereco) throws Exception;
    void consultarDenuncia(Denuncia denuncia) throws Exception;
    ArrayList<Denuncia> listagemDenuncia() throws Exception;
    void atualizarDenuncia(String statusDenuncia, String protocolo)throws Exception;

    String formatarDenuncia(String status)throws Exception;
}
