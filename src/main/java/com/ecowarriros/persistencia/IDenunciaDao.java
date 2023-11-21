package com.ecowarriros.persistencia;

import java.util.ArrayList;
import com.ecowarriros.modelos.Denuncia;

public interface IDenunciaDao {
    void cadastroDenuncia(Denuncia denuncia) throws Exception;
    void consultarDenuncia(Denuncia denuncia) throws Exception;
    ArrayList<Denuncia> listagemDenuncia() throws Exception;




}
