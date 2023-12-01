package com.ecowarriors.persistencia;

import java.util.ArrayList;
import com.ecowarriors.modelos.Denuncia;

public interface IDenunciaDao {
    void cadastroDenuncia(Denuncia denuncia) throws Exception;
    void consultarDenuncia(Denuncia denuncia) throws Exception;
    ArrayList<Denuncia> listagemDenuncia() throws Exception;

    void atualizarDenuncia(String cpfDenunciante)throws Exception;


}
